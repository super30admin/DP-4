// Time Complexity : O(m * n), m and n are rows and col, single pass
// Space Complexity : O(m * n), dp matrix of same size used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**Initialize dp matrix with the same dimensions as the original one initialized with all 0’s
 * Starting from index (0,0), for every 1 found in the original matrix, we update the value of the current element as
 * dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
 * We store the max found so far. In this way, we traverse the original matrix once and find out the required maximum size. 
 * This gives the side length of the square, The required result is the area max * max **/

class Maximal_Square {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];  // extra row and col, because dp matrix first row and col will be filled with zero
		int max = Integer.MIN_VALUE;
		//process all elements of matrix
		for(int i=1; i<=matrix.length; i++){
			for(int j=1; j<=matrix[0].length; j++){
				if(matrix[i-1][j-1] == '1'){    //if the original array value has 1
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
					if(max < dp[i][j])
						max = dp[i][j]; //updating the max value
				}
			}
		}
		return max * max;
	}
}
