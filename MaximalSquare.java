// Time Complexity : O(n*m)
// Space Complexity : O(n*m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int n=matrix.length; int m=matrix[0].length;
        
        int[][] dp=new int[n+1][m+1];
        int max=Integer.MIN_VALUE;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                        max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}