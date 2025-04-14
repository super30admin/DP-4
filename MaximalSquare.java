// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m+1][n+1];
    int maxSquare = 0;
    for(int i = 1; i<m+1; i++) {
      for(int j = 1; j<n+1; j++) {
        if(matrix[i-1][j-1] == '0') {
          dp[i][j] = 0;
        } else {
          dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
          maxSquare = Math.max(maxSquare, dp[i][j]);
        }
      }
    }
    return maxSquare*maxSquare;
  }
}