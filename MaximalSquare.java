//Time Complexity: O(mn)
//Space Complexity: O(mn)

/*
 * here we maintain a dp matrix which stores the number of 1's 
 * in the diagonal, left and up from the current position. whatever
 * is the max value we get we return the square of it.
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxVal = 0;
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                }
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }
        return maxVal * maxVal;
    }
}