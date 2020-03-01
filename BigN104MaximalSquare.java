// Time complexity is O(m*n)^2
// Space complexity is O(1)
// This solution is submitted on leetcode

public class BigN104MaximalSquare {
	class Solution {
		public int maximalSquare(char[][] matrix) {
			// edge case
			int row = matrix.length;
			if (row == 0 || matrix == null)
				return 0;
			int column = matrix[0].length;
			int max = 0;
			boolean flag = false;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (matrix[i][j] == '1') {
						flag = true;
						int curr = 1;
						while (i + curr < row && j + curr < column && flag) {
							for (int k = i + curr; k >= i; k--) {
								if (matrix[k][j + curr] == '0') {
									flag = false;
									break;
								}
							}
							for (int p = j + curr; p >= j; p--) {
								if (matrix[i + curr][p] == '0') {
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
	}
}