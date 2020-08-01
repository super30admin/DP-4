// Time Complexity : O(mn), matrix size
// Space Complexity : O(mn), matrix size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//TC : O(mn)
//SC : O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        //check for empty case
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //var max is initialize to 0, max is length of the sq, area = max*max
        int max = 0;
        //create dp array
        int [][] dp = new int[m][n];
        
        //check each cell once
        //if cell is != 0
        //val of length of a square that can be formed at the cell is Min of adj cells + 1
        //if 0, then val is 0
        //for first row and first col, val at cell is same as input
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                //for first row and first col, val at cell is same as input
                if(i == 0 || j == 0) {
                    //convert char to int value
                    dp[i][j] = matrix[i][j] - '0';
                    //check max here as well, as matrix size can be (1,n)/(m,1)
                    max = Math.max(max, dp[i][j]);
                }
                
                else {
                    //if matrix[i][j] == '0', val in Dp array remains 0
                    if(matrix[i][j] != '0') {
                        //if != 0
                        //get min of adj cells (3 dir : left, top, diagonal up) add 1
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                        //check with main max, if dp[i][j] is greater update max
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }    
        //return area (area = length*length)
        return max*max;
    }
}

