/* 
Time Complexity: O(m * n)
   - Traverse each cell once, update dp in O(1).

Space Complexity: O(m * n)
   - dp table of size (m+1) × (n+1).

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - Use dynamic programming with a 2D table (m+1 × n+1) for convenience (avoid bounds checks).
// - dp[i][j] = size of the largest square ending at (i-1, j-1).
// - Transition: 
//     if matrix[i-1][j-1] == '1':
//         dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
//     else dp[i][j] = 0
// - Track the maximum side length while filling dp.
// - Return area = maxSide × maxSide.


public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
