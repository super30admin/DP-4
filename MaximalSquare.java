package Dec7;

class MaximalSquare {
	public int maximalSquare(char[][] matrix) {

		// edge
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;
		boolean flag = false;
		int max = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// if current element is not 1 itself, we cannot form a square starting this
				// position, so proceed to next element in given matrix.There is no point
				// processing current element cz it is itself 0.
				if (matrix[i][j] != '1') {
					continue;
				}

				// if current element is 1 itself, we can form a square starting this position
				// of min size 1 for sure, so continue to search diagonally till you keep
				// finding 1. At every diagonal point where you get 1, check from there till the
				// ceiling row and ceiling column, if you keep getting 1. If yes, we can
				// increment currCount. If at any point, 1 not found in row/column, process next
				// element cz there is no point forming squares further since a 0 has been
				// found.

				int currCount = 1;
				flag = true;

				while (i + currCount < m && j + currCount < n && flag == true) {

					int diagRow = i + currCount;
					int diagCol = j + currCount;

					if (matrix[diagRow][diagCol] != '1') {
						flag = false;
						break;
					}

					if (!flag) {
						break;
					}

					// check for 1 in same col
					for (int x = diagRow; x >= i; x--) {
						if (matrix[x][diagCol] != '1') {
							flag = false;
							break;
						}
					}

					if (!flag) {
						break;
					}

					// check for 1 in same row
					for (int x = diagCol; x >= j; x--) {
						if (matrix[diagRow][x] != '1') {
							flag = false;
							break;
						}
					}

					if (flag) {
						currCount++;
					}
				}

				max = Math.max(currCount, max);
			}

		}
		return max * max;
	}

}
