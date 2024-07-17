// Time Complexity : O(m*n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Initialization: Use a dynamic programming array dp to keep track of the maximum side length of the square ending at each position in the current row.
//Update: Iterate through the matrix, updating dp[j] based on the values of dp[j-1], dp[j], and a temporary variable for the previous row's value, if the cell contains '1'.
//Result: Track the largest side length found (max) and return its square (max * max).

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int temp = dp[0];
            for (int j = 1; j <= n; j++) {
                int prev = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(dp[j - 1], Math.min(dp[j], temp));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                temp = prev;
            }
        }
        return max * max;
    }
}
