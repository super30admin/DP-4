//Time Complexity: O(m*n)
//SPace Complexity: O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length ==0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int [] dp = new int[n+1];
        int curr = 0, diag = 0;

        for (int i =1; i <= m; i++) {
            for (int j=1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    curr = dp[j];
                    dp[j] = Math.min(dp[j-1], Math.min(curr, diag)) + 1;
                    max = Math.max(max, dp[j]);
                    diag = curr;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return max*max;
    }
}
