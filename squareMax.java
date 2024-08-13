/*
TC --> O(n*m)
SC --> O(n*m)
 */
class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n]; // Use int[][] instead of char[][] for easier calculations
        int res = 0;

        // Initialize the dp array based on the last row and last column of the matrix
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = matrix[i][n - 1] - '0';
            res = Math.max(res, dp[i][n - 1]); // Update res if there's a 1 in the last column
        }

        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = matrix[m - 1][j] - '0';
            res = Math.max(res, dp[m - 1][j]); // Update res if there's a 1 in the last row
        }

        // Fill the dp array for other cells
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        // Return the area of the largest square
        return res * res;
    }
}
