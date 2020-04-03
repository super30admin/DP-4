// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        int [][] dp = new int[row][col];

        for(int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }

        for(int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }

         for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i][j-1], 
                               Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
}