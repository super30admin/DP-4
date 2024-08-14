// Time Complexity: O(mn)
// Space Complexity: O(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int diag = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    int curr = 1 + Math.min(dp[j - 1], Math.min(dp[j], diag));
                    dp[j] = curr;
                    max = Math.max(max, curr);
                    diag = temp;
                } else
                    dp[j] = 0;
            }
        }

        return max * max;

    }
}