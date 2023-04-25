// Time Complexity : O(m * n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

 

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length; 
        int max = 0; 
        int dp[] = new int[n+1];
        for(int i = 1; i <= m; i++){
            int diagUp = 0;
            for(int j = 1 ; j <= n; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1+ Math.min(dp[j],Math.min(dp[j-1],diagUp));
                    max = Math.max(max, dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        return max * max;
    }
}