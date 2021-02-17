
/*  The complexity of the brute force algorithm is O(m*n)^2 where .
 * Space complexity is O(1) .
 */

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return 0;

		int m = matrix.length, n = matrix[0].length;

		int max = 0;
		boolean flag = false;

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == '1') {

					flag = true;
					int curr = 1;

					while (i + curr < m && j + curr < n && flag) {

						for (int k = i + curr; k >= i; k--) {

							if (matrix[k][j + curr] == '0') {
								flag = false;
								break;
							}

						}

						for (int k = j + curr; k >= j; k--) {

							if (matrix[i + curr][k] == '0') {
								flag = false;
								break;
							}

						}

						if (flag)
							curr++;

					}

					max = Math.max(max, curr);
				}

			}
		}

		return max * max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
