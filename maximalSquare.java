// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Tried 2D Dp Solution then optimised it to 1D

public class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int max = 0; // max len of a side of maximalSquare
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int diagup = 0;
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(dp[j], Math.min(diagup, dp[j - 1]));
                    max = Math.max(max, dp[j]);
                    diagup = temp;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return max * max;
    }
}
