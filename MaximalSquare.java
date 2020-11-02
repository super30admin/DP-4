// Time:O(N*N)
// Space:O(N) 
// Logic: Find minimum or the three cells for i,j (i-1,j && i-1,j-1, i, j-1) and add +1 to find the square length  

class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        
        int[][] dp = new int[rows + 1][cols + 1];
        
        int maxLength = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}
