/* Time Complexity : O(m*n)) 
 *  m - rows - matrix 
 *  n - cols - matrix */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//DP

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int [n+1];
        //Iterate over the matrix to find '1'
        for(int i = 1; i <= m; i ++){
            int diagUp = 0;
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    int temp = dp[j];
                                            //top, left, top-left(diag Up)
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], diagUp));
                    maxLen = Math.max(maxLen, dp[j]);
                    //to store the top-left ele for the next ele to be processed
                    diagUp = temp;
                }
                else{
                    dp[j] = 0;
                }
            }
        }
        return maxLen * maxLen;
    }
}