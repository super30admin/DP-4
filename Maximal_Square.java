// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0)return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               if(matrix[i-1][j-1]=='1'){
                   dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
               }
               max = Math.max(max,dp[i][j]);
           } 
        }    
        return max*max;
    }
}