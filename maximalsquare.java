// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}