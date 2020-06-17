//Approach: Using DP matrix we can solve the repeated sub problem issue. We create a DP matrix in a such a way that at every point we calculate the max length of the square that could be formed. We achieve that taking the min among top, left and top left diagonal element and adding 1 to it only if the original element in given matrix is 1 already. This is how we build our DP matrix using memoized values.

//time complexity O(m x n) since we iterate over each element once
//space complexity O(m+1 x n+1) size of DP matrix

class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
 	        int[][] dp = new int[m+1][n+1];
		for (int i = 1; i<m+1; i++) {
			for (int j = 1; j<n+1; j++) {
                		if(matrix[i-1][j-1] == '1'){
                    			dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                    			max = Math.max(max, dp[i][j]);
                		}
			}
		}
		return max * max;
	}
}
