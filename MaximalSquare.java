// tc=sc= O(m*n)
class Solution {
    public int maximalSquare(char[][] mat) {
        if(mat==null || mat.length==0) return 0;
        int m= mat.length;
        int n= mat[0].length;
        
        int dp[][]= new int [m+1][n+1];
        int max=0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(mat[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                    max= Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}