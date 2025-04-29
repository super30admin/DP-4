// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;

        int cols = matrix[0].length;
        int maxLen = 0;

        // DP table to store the size of the largest square that ends at matrix[i][j]
        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                // Only consider '1's
                if (matrix[i - 1][j - 1] == '1') {
                    // Update the dp value based on the minimum of the top, left, and diagonal cells
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        // Return the area of the largest square
        return maxLen * maxLen;
    }
}
