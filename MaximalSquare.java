class Solution {
    // 2D array
    public int maximalSquare2D(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m + 1][n + 1];

        int max = 0;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

    // 1D array
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n + 1];

        int max = 0;

        for (int i = 0; i < m; ++i) {
            int diagonal = dp[0]; // every time when we start a new row, disgonal is the first element (dp[0])
            for (int j = 0; j < n; ++j) {
                int prev = dp[j + 1]; // just store before updating and for next j element, this will act as diagonal
                if (matrix[i][j] == '1') {
                    dp[j + 1] = 1 + Math.min(dp[j + 1], Math.min(dp[j], diagonal));
                    max = Math.max(max, dp[j + 1]);
                } else {
                    dp[j + 1] = 0;
                }
                diagonal = prev;
            }
        }

        return max * max;
    }
}