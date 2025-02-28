// TC: O(m * n) traversing all the elements
// SC: O(m * n) for dp array for using 2d array

// TC: O(m * n) traversing all the elements
// SC: O(n) for dp array for using 1d array

public class MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(new String[][] { { "1", "0", "1", "0", "0" }, { "1", "0", "1", "1", "1" },
				{ "1", "1", "1", "1", "1" }, { "1", "0", "0", "1", "0" } })); // 4
		System.out.println(maximalSquare(new String[][] { { "0", "1" }, { "1", "0" } })); // 1

		System.out.println(
				maximalSquareUsing1Darray(new String[][] { { "1", "0", "1", "0", "0" }, { "1", "0", "1", "1", "1" },
						{ "1", "1", "1", "1", "1" }, { "1", "0", "0", "1", "0" } })); // 4
		System.out.println(maximalSquareUsing1Darray(new String[][] { { "0", "1" }, { "1", "0" } })); // 1
	}

	// In this approach, the current elements value depends on the top,
	// left and diagonally top left value. and min of 3 + 1 is set. This uses the 2d
	// matrix.
	public static int maximalSquare(String[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (matrix[i - 1][j - 1].equals("1")) {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}

	// In this approach, single array is used to keep the count of min. as it is
	// only dependent on the previous index and above.
	public static int maximalSquareUsing1Darray(String[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[] dp = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int temp = dp[0];
			for (int j = 1; j < n + 1; j++) {
				int prev = dp[j];
				if (matrix[i][j - 1].equals("1")) {
					dp[j] = Math.min(dp[j], Math.min(temp, dp[j - 1])) + 1;
					max = Math.max(max, dp[j]);
				} else {
					dp[j] = 0;
				}
				temp = prev;
			}
		}
		return max * max;
	}

}
