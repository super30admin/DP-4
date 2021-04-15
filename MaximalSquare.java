// TC - O(m*n)
// SC - O(m*n)

// LC - 221

class Solution {
    public int maximalSquare(char[][] matrix) {
		// Sanity check
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
		// Initializing a new dp array
        int[][] dp = new int[m+1][n+1];
        int max = 0;
		// Iterate 
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
				// We only move forward if current character in matrix is '1'
                if(matrix[i-1][j-1] == '1'){
					// current val of dp will be 1 plus min of surrounding values of current i, j. left, top, left diagonal are the directions to check
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
					// update max
                    max = Math.max(dp[i][j], max);
                }
            }
        }
		// return max*max as we need to return area
        return max*max;
    }
}