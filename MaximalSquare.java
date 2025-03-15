/*
 * TC: O(n^2)
 * SC: O(n^2)
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int i, j;
        int max = 0;
        // if the elements above, to the left and to the top-left are all non-zero
        // and the current cell is one, then that means that this cell now
        // forms a larger square, so we add one to the min value of all 3 values
        for(i = 1; i < m + 1; i++) {
            for(j = 1; j < n + 1; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        // we need the area, max is the side/diagonal length
        return max * max;
    }
}