// Time complexity is O(m*n)
// Space complexity is O(m*n)
// This solution is submitted on leetcode

public class BigN105MaximalSquareDPSolution {
	class Solution {
		public int maximalSquare(char[][] matrix) {
			int row = matrix.length;
			if (matrix == null || row == 0)
				return 0;
			int column = matrix[0].length;
			int max = 0;
			int[][] dp = new int[row + 1][column + 1];
			for (int i = 1; i < dp.length; i++) {
				for (int j = 1; j < dp[0].length; j++) {
					if (matrix[i - 1][j - 1] == '1') {
						int temp = Math.min(dp[i][j - 1], dp[i - 1][j]);
						dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
						max = Math.max(max, dp[i][j]);
					}
				}
			}
			return max * max;
		}
	}
}