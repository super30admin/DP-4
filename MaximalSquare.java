// Time complexity : O(m*n)
// Space complexity : O(m*n)
class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        int result = maximalSquare(matrix);
        System.out.println(result);
    }

    private static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}