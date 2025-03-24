/*
Time Complexity: O(m × n) (Each cell is processed once).
Space Complexity: O(n) (Using a single row DP array).

Iterate bottom-up through the matrix, using a 1D DP array (dp[n+1]) to store the max square size at each cell, while maintaining a diagDown variable for diagonal values.
If matrix[i][j] == '1', update dp[j] as 1 + min(dp[j] (below), dp[j+1] (right), diagDown (diagonal-down)), else set dp[j] = 0.
Keep track of the maximum square size (max) and return max * max as the final area.
 */


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n + 1];
        for (int i = m - 1; i >= 0; i --) {
            int diagDown = 0;
            for (int j = n - 1; j >= 0; j --) {
                int temp = dp[j];
                if (matrix[i][j] == '1') {
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j + 1], diagDown));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagDown = temp;
            }
        }
        return max * max;
    }
}