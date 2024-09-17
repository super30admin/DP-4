//Time: O(m*n)
//Space: O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];  // DP table to store largest square sizes
        int maxSide = 0;  // Track the largest square side

        // Iterate through the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    // For the first row or first column, the square side is the value itself
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Update the DP table by taking the minimum of three neighboring cells
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    // Track the maximum square side
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // The area of the largest square is the square of the side length
        return maxSide * maxSide;
    }
}