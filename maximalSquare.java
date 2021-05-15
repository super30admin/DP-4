// Time Complexity : O(MxN)
// Space Complexity : O(MxN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n]; 
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = matrix[i][j] - '0';
                if(i == 0 || j == 0){
                    max = Math.max(dp[i][j],max);
                }else if(dp[i][j] == 1){
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                        max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
