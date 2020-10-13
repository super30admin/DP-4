//  Problem 1 - Maximal Square
// Time Complexity: O(n * m) where n = number of rows, m = number of columns
// Space Complexity: O(n * m)

// Algorithm
// 1 - initiliaze a 2D array
// 2 - loop over row of 2D array starting from index 1
// 3 - loop over col of 2D array starting from index 1
// 4 - condition if the element at [i-1][j-1] in the matrix is 1
// 5 - current element is 1 + min of (left, top and diagonal left)
// 6 - get the max
class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int n = matrix.length;
    int m = matrix[0].length;
    int max = Integer.MIN_VALUE;
    // 1
    int[][] dp = new int[n + 1][m + 1];
    // 2
    for (int i=1; i<=n; i++) {
      // 3
      for (int j=1; j<=m; j++) {
        // 4
        if (matrix[i - 1][j - 1] == '1') {
          // 5
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
          // 6
          max = Math.max(max, dp[i][j]);
        }
      }
    }

    return max * max;
  }
}
