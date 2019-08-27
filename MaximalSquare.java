//use dynamic programing
/*11
  11   for bottom right 1 all upper side 1 present therefore square of size 2 possible in dp array at position 1 ,1 store 2.
  which is calcualte as Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1; */
//cacualte similarvalues for all matrix

/*Time complexity : O(mn)O(mn). Single pass.

Space complexity : O(mn)O(mn). Another matrix of same size is used for dp.*/
public class MaximalSquare {
	    public int maximalSquare(char[][] matrix) {
	        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
	        int[][] dp = new int[rows + 1][cols + 1];
	        int maxsqlen = 0;
	        for (int i = 1; i <= rows; i++) {
	            for (int j = 1; j <= cols; j++) {
	                if (matrix[i-1][j-1] == '1'){
	                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
	                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
	                }
	            }
	        }
	        return maxsqlen * maxsqlen;
	    }


}
