// TC: O(m x n)
// SC: O(n)

class Solution {
    public int maximalSquare(char[][] mat) {
        if(mat == null || mat.length == 0) {
            return 0;
        }
        int m, n, max, prev;
        m = mat.length;
        n = mat[0].length;
        max = 0;
        prev = 0;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(mat[i - 1][j - 1] == '1') {
                    int temp = dp[j];
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], prev)) + 1;
                    prev = temp;

                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max * max;
    }
}