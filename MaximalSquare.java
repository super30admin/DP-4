// https://www.youtube.com/watch?v=aYnEO53H4lw
// Time Complexity: O(mn)
// Space COmplexity: O(mn)

class Solution {
    public int maximalSquare(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = (matrix[i][j] == '0')? 0:1;
                } else if(matrix[i][j]=='0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }

                if(dp[i][j]>max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}