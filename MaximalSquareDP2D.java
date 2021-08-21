// TC: O(m x n)
// SC: O(m x n)

class Solution {
    public int maximalSquare(char[][] mat) {
        if(mat == null || mat.length == 0) {
            return 0;
        }
        int m, n, max;
        m = mat.length;
        n = mat[0].length;
        max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(mat[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}