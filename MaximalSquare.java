class Solution {
    public int maximalSquare(char[][] matrix) {
        int m= matrix.length, n= matrix[0].length;
        int[][] dp= new int[m+1][n+1];
        int max=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]= 1+ Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    }
}

//Time complexity : O(m*n)
//Space complexity : O(m*n)
