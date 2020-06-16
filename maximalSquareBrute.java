//time complexity O((m x n)^2) The reason being we are iterating over the whole matrix and for each element we are again iterating over the rows and columns
//space complexity O(1)

class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int curr = 0;
		boolean flag = false;
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<n; j++) {
				if (matrix[i][j] == '1') {
					curr = 1;
					flag = true;
					while (i + curr<m && j + curr<n && flag) {//boundaries while incrementing curr
						//row iteration
						for (int k = i + curr; k >= i; k--) {
							if (matrix[k][j + curr] == '0') {
								flag = false;
								break;
							}
						}
						//column iteration
						for (int k = j + curr; k >= j; k--) {
							if (matrix[i + curr][k] == '0') {
								flag = false;
								break;
							}
						}
						if (flag) curr++;
					}
					max = Math.max(curr, max);
				}
			}
		}
		return max * max;
	}
}
