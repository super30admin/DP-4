public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare solution = new MaximalSquare();

        // Example input matrix
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };

        int maxArea = solution.maximalSquare(matrix);
        System.out.println("Maximum area of the square in the matrix: " + maxArea);
    }
}