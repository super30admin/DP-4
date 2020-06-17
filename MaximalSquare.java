// Time Complexity : O(n); n - number of elements in the matrix
// Space Complexity : O(n); n - number of elements in the matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
	1. Initialize dp[m+1][n+1] and fill 1st row and 1st col with zeros (automatic in java as it's default value)
	2. Find '1' in the original matrix
	3. dp[i][j] = 1 + Min(top, top-left, left)
	4. Keep track of maximum value throughout the dp matrix 
*/



class MaximalSquare {
	//DP
	public int maximalSquare(char[][] matrix) {
		//edge
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int maxSquare = 0;
		int[][] dp = new int[m+1][n+1]; 
		
		for(int i = 1; i < m+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(matrix[i-1][j-1] == '1') {
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
					maxSquare = Math.max(maxSquare, dp[i][j]);
				}
			}
		}
		return maxSquare*maxSquare;
	}
}


