package DP4;

public class MaximalSquare {
	//TC : o(m*n)
	//SC : o(m*n)
	//Approach : create a DP matrix. If element in matrix is 0, fill dp with 0 otherwise taking min of digonal up, up column and left row elements and max in table would form max square

	class Solution {
	    public int maximalSquare(char[][] matrix) {
	        if(matrix == null || matrix.length == 0) return 0;
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int max = 0;
	        int[][] dp = new int[m+1][n+1];
	        for(int i=1; i<=m; i++){
	            for(int j=1; j<=n; j++){
	                if(matrix[i-1][j-1] == '1'){
	                    
	                    int curr = Math.min(dp[i-1][j-1] , Math.min(dp[i][j-1] , dp[i-1][j])) + 1;
	                    dp[i][j] = curr;
	                    max = Math.max(max, curr);
	                }
	            }
	        }
	        return max*max;
	    }
	}
}
