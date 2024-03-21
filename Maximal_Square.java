public class Maximal_Square {
    //TC: O(m*n)
    //SC: O(m*n)
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (matrix == null || rows == 0) return 0;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];
        int largest = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        return largest * largest;
    }
}
