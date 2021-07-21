// Time Complexity : O(mn POW 2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int result = 0;
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					result = Math.max(result, getSquareSize(matrix, i, j, m, n));
				}
			}
		}

		return result*result;
	}

	private int getSquareSize(char[][] matrix, int i, int j, int m, int n) {
		int counter = 1;
		boolean isBreach = false;

		while (!isBreach) {
			int row = i + counter;
			int col = j + counter;
			if(row<m && col<n) {
				for (; col >= j; col--) {
					if (matrix[row][col] == '0') {
						isBreach = true;
						break;
					}
				}
				
				col = j + counter;
				
				for (; row >= i; row--) {
					if (matrix[row][col] == '0') {
						isBreach = true;
						break;
					}
				}
			}else {
				isBreach=true;
			}
			counter++;				

		}

		return counter - 1;
	}
	
	public static void main(String[] args) {
		//char[][] matrix= new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		char[][] matrix= new char[][] {{'0','1'},{'1','0'}};
		
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}
}
