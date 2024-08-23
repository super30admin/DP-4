//Time = O(mn), m&n are dimensions of input matrix
//Space = O(mn)

class Solution {
    public int maximalSquare(char[][] matrix) {
        // Get dimensions of input matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize a 2D dp array to store intermediate results
        int[][] dp = new int[m+1][n+1];

        // Initialize a variable to keep track of maximum square length seen so far
        int maxSquareLen = 0;

        // Loop through each position in the matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If current position in matrix contains a '1'
                if (matrix[i-1][j-1] == '1') {
                    // Update the corresponding value in the dp array as follows:
                    // Take the minimum value of the three adjacent positions above, to the left, and diagonally up to the left of the current position
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;

                    // Update maxSquareLen if the length of the current square is greater than maxSquareLen
                    maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
                }
            }
        }

        // Return area of largest square seen, which is just maxSquareLen squared
        return maxSquareLen * maxSquareLen;
    }
}
