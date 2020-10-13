// Problem 1 - Maximal Square
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

// Problem 2 - Partition Array for Maximum Sum
// Time Complexity: O(n * k) where n = length of array
// Space Complexity: O(n)

// Algorithm
// 1 - initialize an array
// 2 - loop over length of array
// 3 - initiliaze a max variable
// 4 - loop for k times by considering out of bounds logic as well
// 5 - get the max
// 6 - return the last element
class Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    // 1
    int[] dp = new int[arr.length];
    // 2
    for (int i=0; i<arr.length; i++) {
      // 3
      int max = Integer.MIN_VALUE;
      // 4
      for (int j = 1; j<=k && (i-j+1)>=0; j++) {
        // 5
        max = Math.max(max, arr[i - j + 1]);
        if (i >= j) {
          dp[i] = Math.max(dp[i], dp[i - j] + max*j);
        } else {
          dp[i] = Math.max(dp[i], max*j);
        }
      }
    }
    // 6
    return dp[arr.length - 1];
  }
}
