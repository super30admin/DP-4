// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int prevDiagonal;
        int result=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                   if(i==0 || j==0){
                       dp[i][j]=1;
                   }else{
                       dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j]);
                       dp[i][j]=Math.min(dp[i-1][j-1],dp[i][j]);
                       dp[i][j]=dp[i][j]+1;
                   }
                    result=Math.max(result,dp[i][j]);
               }
            }
        }
        
        return result*result;
    }
}