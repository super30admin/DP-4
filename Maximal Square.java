// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return 0;
    int cnt = 0;
    int rows = matrix.length, cols = matrix[0].length;
    int[][] dp = new int[rows + 1][cols + 1];

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
          cnt = Math.max(cnt, dp[i][j]);

        }
      }
    }
    return cnt * cnt;
  }
}