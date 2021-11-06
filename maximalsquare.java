class maximalsquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m= matrix.length;
        int n= matrix[0].length;
        int []dp=new int[n+1];
        int prev=0;
        int diagup=0;
        int max= 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                prev=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=1+Math.min(dp[j-1], Math.min(dp[j],diagup));
                    max=Math.max(max,dp[j]);
                }
                else{
                    dp[j]=0;
                }
                diagup=prev;
            }
        }
        return max*max;
    }
}