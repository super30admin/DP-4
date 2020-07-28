// Time complexity - O(mn)
// Space complexity - O(mn)

// DP - get min area of neighbor indexes + 1

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1 ; j <= n; j++){
               if(matrix[i-1][j-1] == '1'){
                   dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])); // dp logic
                   max = Math.max(max,dp[i][j]);
               }
            }
        }
        return max*max;
    }
}
