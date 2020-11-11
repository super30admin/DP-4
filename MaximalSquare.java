// Time Complexity : O(mn)
// Space Complexity :O(mn), dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// maintain dp array which indicates the max square size possible at that index
// if matrix[i][j]=='1',  dp[i][j] = min (dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
// return max element in dp array 

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int maxSquareSize = 0;
        
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            if(matrix[i][0]=='1'){
                dp[i][0] = 1;
                maxSquareSize = 1;
            }
        }
        for(int j=0; j<n; j++){
            if(matrix[0][j]=='1'){
                dp[0][j] = 1;
                maxSquareSize = 1;
            }
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1])+1;
                    if(maxSquareSize<dp[i][j]){
                        maxSquareSize = dp[i][j];
                    }
                }
            }
        }
        
        return maxSquareSize*maxSquareSize;
    }
}