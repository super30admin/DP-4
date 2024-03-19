//TC:O(m*n)
//SC:O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int result=Integer.MIN_VALUE;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                 if(matrix[i-1][j-1]=='1')
                 {
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
                 }
                 result=Math.max(dp[i][j],result);
            }
        }
        return result*result;
    }
}