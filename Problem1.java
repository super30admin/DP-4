package DP-4;
// TC: O(m*n)
// SC: O(n)
public class Problem1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix.length == 0 || matrix == null)
            return 0;
        int[] dp = new int[n + 1];
        int maxValue = 0;

        for (int i = 1; i <= m; i++) {
            int diagVal = 0;
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j - 1], diagVal));
                    maxValue = Math.max(maxValue, dp[j]);
                    diagVal = temp;
                } else {
                    dp[j] = 0;
                }

            }
        }
        return maxValue * maxValue;
    }

}
