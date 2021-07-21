
// Time Complexity : O(mn)
// Space Complexity : O(mn)//dp array size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. create dp array with one extra column and row and initial values will be 0.
 * 2. when element char is 1 find min of consecutive three elements values in dp array and add 1
 * 3. while calculating find max value and save it in result.
 */

public class MaximalSquareDP {
	public int maximalSquare(char[][] matrix) {
		int result = 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
					result = Math.max(result, dp[i][j]);
				}
			}
		}

		return result * result;
	}
}
