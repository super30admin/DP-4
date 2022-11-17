// TC : M * N
// SC : M * N

class Solution {
    
    public int maximalSquare(char[][] matrix) {
        
        int[][] dirs = new int[][]{{0, -1}, {-1, -1}, {-1, 0}};
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i - 1][j], dp[i-1][j-1])) +1;
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max*max;
    }
}
