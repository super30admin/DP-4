//Time complexity is O(M*N)
//Space complexity is O(M*N)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i+1][j+1]=Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j]))+1;
                }
                else{
                    dp[i+1][j+1]=0;
                }
                result=Math.max(result, dp[i+1][j+1]);
            }
        }
        return result*result;
    }
}