//Time Complexity : O(M*N) 
//Space Complexity : O(M*N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Iterate over the matrix. If 1 is found, then take the minimum of up, left and
 * diagonal elements of it and add +1 to it. This gives the maximum square that
 * can be formed till then. Use max variable to store max value. return max.
 *
 */
class Solution {
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
			max = Math.max(max, dp[i][0]);
		}

		for (int j = 0; j < matrix[0].length; j++) {
			dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
			max = Math.max(max, dp[0][j]);
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0')
					continue;
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				max = Math.max(max, dp[i][j]);
			}
		}
		return max * max;
	}
}