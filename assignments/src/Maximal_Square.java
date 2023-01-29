// Approach: Dynamic Programming Space Optimized
// Time: O(mn)
// Space: O(n)
class Maximal_Square {
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;

        int dp[] = new int[cols+1];
        int maxSqLength = 0, prev = 0;

        for (int i = 1; i<=rows; i++) {
            for (int j = 1; j<=cols; j++) {
                int tmp = dp[j];
                if (matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                    maxSqLength = Math.max(dp[j], maxSqLength);
                }
                else {
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return maxSqLength * maxSqLength;
    }
}