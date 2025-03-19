class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = Integer.MIN_VALUE;
        int m= matrix.length;
        int n= matrix[0].length;
       int[][] dp = new int[m+1][n+1];
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(matrix[i][j] == '1'){
                dp[i][j]=1+Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]));
                res= Math.max( dp[i][j],res);
                
                }
            }
        }
        return res*res;
        
    }
}

//tc: O(m X n)
//sc: O(m X n)