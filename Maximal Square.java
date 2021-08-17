class Solution {
    public int maximalSquare(char[][] matrix) {

        int[][] dp = new int[matrix.length+1][matrix[0].length+1];

        int max = 0;

        for(int i=1 ; i<=matrix.length ; i++)
        {
            for(int j=1 ; j<=matrix[0].length ; j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }

                max = Math.max(dp[i][j],max);
            }
        }

        return max*max;

    }
}
