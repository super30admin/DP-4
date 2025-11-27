/**
 * Maximal Square — LeetCode 221
 * https://leetcode.com/problems/maximal-square/
 *
 * Approach:
 * This is a bottom-up dynamic programming solution. We create a DP table with
 * an extra row and column (padding) so we can safely reference dp[i+1][j],
 * dp[i][j+1], and dp[i+1][j+1] when computing dp[i][j]. For each cell that
 * contains '1', dp[i][j] stores the side length of the largest square with
 * top-left corner at (i, j). The recurrence is:
 *   dp[i][j] = 1 + min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])  if matrix[i][j] == '1'
 * Track the maximum side length and return its area (side * side).
 *
 * Time Complexity: O(m * n) where m = number of rows and n = number of columns.
 * Space Complexity: O(m * n) for the dp table. This can be optimized to O(n)
 *                 by rolling arrays because each row depends only on the next row.
 */
public class MaximalSquareDP {


    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int rLength = matrix.length;
        int cLength = matrix[0].length;
        int[][] dp = new int[rLength+1][cLength+1];

        for (int i = rLength - 1; i >= 0; i--) {
            for (int j = cLength - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
