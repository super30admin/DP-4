//Time Complexity - O(n ^ 2)
//Space Complexity - O(m x n)
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = matrix[i][j] - '0';
                if (curr == 1) {
                    int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    int up = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    int diag = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;

                    dp[i][j] = curr + Math.min(left, Math.min(up, diag));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
