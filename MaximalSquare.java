// Time Complexity: O(m * n), m - rows, n - cols
// Space Complexity: O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use tabulation dp, top down in input matrix
// 2. To fill the dp matrix square side, it's the minimum of its 3 neighbors + 1
// 3. Return the area as maxSide * maxSide

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows+1][cols+1];

        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {

                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1],
                            Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
