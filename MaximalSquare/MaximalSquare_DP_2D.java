/* Time Complexity : O(m*n)) 
 *  m - rows - matrix 
 *  n - cols - matrix */
/* Space Complexity : O(m*n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DP - 2D

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int [m+1][n+1];
        //Iterate over the matrix to find '1'
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                                            //top, left, top-left(diag Up)
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}