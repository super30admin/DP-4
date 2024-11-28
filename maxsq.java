class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] dp = new int[m+1];
        int max=0;
        for(int i=0;i<n;i++){
            int diag=0;
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    int temp=dp[j+1];
                    dp[j+1]=1+Math.min(dp[j],Math.min(dp[j+1],diag));
                    diag=temp;
                    max=Math.max(max,dp[j+1]);
                }
                else{
                    dp[j+1]=0;
                }   
            }
        }
        return max*max;
    }
}
