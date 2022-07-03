
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes


class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxS = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                    maxS = Math.max(maxS, dp[i][j]);
                }
            }
        }
        return maxS * maxS;
    }
}