// Time Complexity : O(n*m) where n- # of rows, m - # of cols
// Space Complexity : O(n*m) where n- # of rows, m - # of cols
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix == null) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int res = Integer.MIN_VALUE;
        
        // calculate the diagonal by taking the minimum of the 3 preceeding cells i,j-1; i-1,j ; i-1,j-1 ( + 1)
        // validate the diagonal and store the int values in the dp matrix and use the dp matrix values to validate
      
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1] != '0'){
                    dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
}
