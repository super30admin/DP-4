//https://leetcode.com/problems/maximal-square/
/*
Time: O(mn) where m=rows n=cols
Space: O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];

        int maxsqlen = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') // If it is 0, just leave it as 0.
                {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1; // (Min of all
                                                                                                     // surrounding 3
                                                                                                     // vals) + 1
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }

        return maxsqlen * maxsqlen;
    }

}
