// Time Complexity : O(m*n), m -> Number of rows, n -> Number of Columns
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class MaximalSquare {
	/********************* Brute Force *********************/
	// Time Complexity : O((m*n)^2), m -> Number of rows, n -> Number of Columns
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int maximalSquareBruteForce(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int currLen = 0;
		int maxLen = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean flag = false;
				if (matrix[i][j] == '1') {
					flag = true;
					currLen = 1;
					while (i + currLen < m && j + currLen < n && flag) {
						// Column Check
						for (int k = i + currLen; k >= i; k--) {
							if (matrix[k][j + currLen] == '0') {
								flag = false;
								break;
							}
						}

						// Row Check
						for (int k = j + currLen; k >= j; k--) {
							if (matrix[i + currLen][k] == '0') {
								flag = false;
								break;
							}
						}

						if (flag) {
							currLen++;
						}
					}
				}
				maxLen = Math.max(currLen, maxLen);
			}
		}

		return maxLen * maxLen;
	}

	/********************* Dynamic Programming *********************/
	// Time Complexity : O(m*n), m -> Number of rows, n -> Number of Columns
	// Space Complexity : O(m*n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int maximalSquareDP(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int maxLen = 0;
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}

		return maxLen * maxLen;
	}

	/********************* Optimized Dynamic Programming *********************/
	// Time Complexity : O(m*n), m -> Number of rows, n -> Number of Columns
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int maxLen = 0;
		int[] dp = new int[n + 1];
		int prev = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
					maxLen = Math.max(maxLen, dp[j]);
				} else {
					dp[j] = 0;
				}
				prev = temp;
			}
		}

		return maxLen * maxLen;
	}

	public static void main(String[] args) {
		MaximalSquare obj = new MaximalSquare();
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		System.out.println("Maximum area of a square in the given matrix: " + obj.maximalSquare(matrix));
	}

}
