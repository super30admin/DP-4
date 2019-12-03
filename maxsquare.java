//Space complexity-O(m*n)
//Time complexity-O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows=matrix.length;
        if(rows==0)return 0;
        int cols=matrix[0].length;
        int [][] dp = new int[rows+1][cols+1];
        int max=0;
        for(int i=1; i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}