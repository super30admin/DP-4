/**
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
 * The algorithm iterates through each cell of the matrix exactly once, performing constant-time operations for each cell.

 * Space Complexity: O(n), where n is the number of columns in the matrix.
 * The space complexity is determined by the 1D DP array of size n + 1, which is used to store the size of the largest square ending at each column.
 */

 class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        // If the matrix is empty, return 0 as there is no square
        if (rows == 0) return 0;
        
        int cols = matrix[0].length;
        // Create a 1D DP array to store the size of the largest square ending at each column
        int[] dp = new int[cols + 1];
        int result = 0;  // To track the size of the largest square found
        int prev = 0;    // This will store the value of dp[col-1] from the previous row
        
        // Fill the DP array
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                int temp = dp[col];  // Store the current dp[col] value before updating it
                
                if (matrix[row - 1][col - 1] == '1') {
                    // Update dp[col] using the value from the previous row and column (prev)
                    dp[col] = Math.min(Math.min(dp[col - 1], dp[col]), prev) + 1;
                    // Update the result if a larger square is found
                    result = Math.max(result, dp[col]);
                } else {
                    // Reset dp[col] to 0 if the cell in the matrix is '0'
                    dp[col] = 0;
                }
                
                prev = temp;  // Update prev to the value of the previous dp[col] before the update
            }
        }
        // The area of the largest square is the square of its side length
        return result * result;
    }
}
