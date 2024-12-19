//Time Complexity: O(m * n) each cell is traversed once
// Space complexity: O(m * n)
public class MaximalSquare {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int max = 0;

            // DP table with an extra row and column for easier indexing
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        // Update the DP value by adding 1 to the minimum of top, left, and top-left
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            // Return the area of the largest square
            return max * max;
        }

        public static void main(String[] args) {
            MaximalSquare solution = new MaximalSquare();

            // Example input
            char[][] matrix = {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            };

            // Test the function
            int result = solution.maximalSquare(matrix);
            System.out.println("The area of the largest square is: " + result); // Expected output: 4
        }
    }

