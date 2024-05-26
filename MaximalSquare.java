class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n+1];
        int diagDown = 0;

        for(int i=m-1; i>= 0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(matrix[i][j] == '1')
                {
                    int temp = dp[j];
                    dp[j] = Math.min(dp[j+1], Math.min(dp[j], diagDown))+1;
                    max = Math.max(max, dp[j]);
                    diagDown = temp;
                }
                else
                {
                    dp[j] = 0;
                }
            }
        }
        return max*max;

    }
}