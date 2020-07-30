// Time Complexity : O(m*n) 
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix==null || matrix.length==0) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for(int i=1;i<matrix.length+1;i++){
            for(int j=1;j<matrix[0].length+1;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1] , dp[i][j-1]))+1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}