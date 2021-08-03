class Solution {
    //Time O(m*n)
    //Space O(m*n)
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
        {
            return 0;
        }
        int m = matrix.length , n = matrix[0].length;
        int[][] DP = new int[m][n];
        
        //Fill first col
        int max = 0;
        for(int i = 0 ; i < m ; i++)
        {
            DP[i][0] = matrix[i][0] - '0';
            if(DP[i][0] == 1) max = 1;
        }
        
        //Fill first row
        for(int i = 0 ; i < n ; i++)
        {
            DP[0][i] = matrix[0][i] - '0';
            if(DP[0][i] == 1) max = 1;
        }
        for(int i = 1 ; i < m ; i++)
        {
            for(int j = 1 ; j < n ; j++)
            {
                if(matrix[i][j] != '0')
                {
                    DP[i][j] = Math.min(Math.min(DP[i-1][j] , DP[i][j-1]) , DP[i-1][j-1]) + 1;
                    max = Math.max(max , DP[i][j]);
                }
                else
                {
                    DP[i][j] = 0;
                }
            }
        }
        return max * max;
    }
}