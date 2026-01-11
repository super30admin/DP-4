// Approach: DP with optimized space
// TC: O(m*n); m = rows, n = columns
// SC: O(n)
class Solution {
    private static final char ONE = '1';
    public int maximalSquare(char[][] matrix) {
        int maximalSquareSize = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] dp = new int[columns + 1]; // Add extra column
        for (int row = rows - 1; row >= 0; row --) {
            int diagonalDown = 0; // reset
            for (int column = columns - 1; column >= 0; column --) {
                int temp = dp[column]; // store the value before it gets modified
                if (matrix[row][column] == ONE) {
                    // Calculate minimum possible square size
                    dp[column] = 1 + Math.min(diagonalDown,
                        Math.min(dp[column], dp[column + 1]));
                    // Maintain maximum possible square size
                    maximalSquareSize = Math.max(maximalSquareSize, dp[column]);
                } else {
                    dp[column] = 0; // reset
                }
                diagonalDown = temp; // update with the previous dp[column] value
            }
        }
        // Return square size
        return maximalSquareSize * maximalSquareSize;
    }
}
