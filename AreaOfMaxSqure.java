// TC: O(3 * m * n) = for every element in matrix we do 3 checks -> O( m * n)
// SC: O(m * n) size of DP matrix
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                    result = Math.max(dp[i][j], result);
                }

            }
        }

        return result * result;
    }
}