// Bruteforce - Accepted
// Time Complexity : O(m^2 * n^2) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        boolean flag = false;
        int row = matrix.length;
        
        if(matrix == null || row == 0) return 0;
        int col = matrix[0].length;
        
        for(int i=0;i<row; i++) {
            for(int j=0;j<col; j++) {
                if(matrix[i][j] == '1') //why '1' and not == 1 (curious)
                {
                    int curr = 1;
                    flag = true;
                    while(i+curr < row && j+curr < col && flag)
                    {
                        for(int k = i+ curr; k>=i; k--)
                        {
                            if(matrix[k][curr+j] == '0') {
                                flag = false; break;
                            }
                        }
                        
                        for(int k = j+ curr; k>=j; k--)
                        {
                            if(matrix[curr+i][k] == '0') {
                                flag = false; break;
                            }
                        }
                        if(flag) curr++;
                    }
                    max = Math.max(max, curr);
                }
                
            }
        }
        return max * max;     
    }
}

// DP - Accepted
// Time Complexity : O(mn) iterate over m x n Matrix
// Space Complexity : O(mn) // DP matrix of m x n
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach
class Solution {
    public int maximalSquare(char[][] matrix) {
       int rows = matrix.length;
        //edge case
        if(matrix == null || rows == 0) return 0;
        int cols = matrix[0].length;
        int max = 0; //max possible square
        int [][]dp = new int [rows+1][cols+1]; // dp matrix with an extra row and col to handle the operations
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(matrix[i-1][j-1] == '1') 
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1; // Min of the 3 neighbors
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max; // return area
    }
}