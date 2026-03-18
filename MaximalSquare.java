/**
 * Uses DP where dp[i][j] represents the side length of the largest square ending at (i, j).
 * If current cell is '1', square size depends on min of top, left, and top-left neighbors.
 * Time: O(m * n), Space: O(m * n)
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length; 
        if (row == 0) return row; // Edge case: empty matrix

        int col = matrix[0].length;
        int max = 0; 

        // Extra padding simplifies boundary checks (avoids i-1/j-1 out of bounds)
        int[][] dp = new int[row + 1][col + 1]; 

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                // Only expand square if current cell is '1'
                if (matrix[i - 1][j - 1] == '1') {

                    // Key insight:
                    // Square size is limited by the smallest of 3 neighbors
                    // (top, left, diagonal) → ensures all sides are valid
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                  Math.min(dp[i - 1][j], dp[i][j - 1]));

                    // Track the largest square side found so far
                    max = Math.max(dp[i][j], max);
                }
                // If '0', dp[i][j] stays 0 → cannot form square
            }
        }

        // Return area, not side length
        return max * max;
    }
}