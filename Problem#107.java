// Maximal Square

// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        
        for(int i = 1; i <= m; i++){
            int diagUp = 0;
            for(int j = 1; j <= n; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j-1], Math.min(dp[j], diagUp));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        return max * max;
    }
}