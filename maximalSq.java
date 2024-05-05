class Solution {
    // Tc: O(m*n) Sc: O(m*n)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int maxSideLength = 0;

        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] == '1') {
                dp[i][n - 1] = 1;
                maxSideLength = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[m - 1][j] == '1') {
                dp[m - 1][j] = 1;
                maxSideLength = 1;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {

                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                    maxSideLength = Math.max(maxSideLength, dp[i][j]);
                }
            }
        }

        return maxSideLength * maxSideLength;

    }
}