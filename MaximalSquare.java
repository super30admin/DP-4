class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // traverse 1*1 square diagonally to expand the square if its '1'
        // and other three diagonally are also '1' -> min of up, left and diagonally left up + 1
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxSquare = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == '1')
                {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i][j])+1;
                    maxSquare = Math.max(maxSquare, dp[i+1][j+1]);
                }
            }
        }

        return maxSquare*maxSquare;
    }
}