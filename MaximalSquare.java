public class MaximalSquare {
    // TC: O(M * N) where M is number of rows and N is number of cols
    // SC: O(M * N) where M is number of rows and N is number of cols
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int top = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    int topLeft = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = Math.min(top, Math.min(left, topLeft)) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
