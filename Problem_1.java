//Time Complexity:O(mn)
//Space Complexity:O(mn) 
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] dp= new int[m+1][n+1];
        int max=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}