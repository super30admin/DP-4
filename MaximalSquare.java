/* 221. Maximal Square - MEDIUM
https://leetcode.com/problems/maximal-square/

Approach : length of square ending at (i,j) will be dependent on the square ending at (i-1,j), (i,j-1), (i-1,j-1).
We then take the minimum of the three and add 1 if the current element is 1.
Why minimum -> because the square ending at (i,j) can only grow to the top left until the point where it hits a 0,
and this is taken into account by the 3 values computed earlier.

TC: O(nm)
SC: O(nm)
*/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int max = Integer.MIN_VALUE;
        
        int[][] dp = new int[r + 1][c + 1];
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
}