// Time Complexity : O(m*n)
// Space Complexity : O(n) optimized space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :   No


// Your code here along with comments explaining your approach
// At every index, we check the maximum square that can be formed with left, up and left up indexes only if the value is 1.
// At any i,j position, the maximum square that can be formed is 1 + minimum of left, up and left up positions.
//  To optimize space, we use a single array of size n+1 and a variable to store the diagonal up value.
// Diagronal up value at index j is the previous value of dp[j-1] before updating it.

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[] dp = new int[n+1];
        
        for(int i=1;i<=m;i++){
            int diagUp = 0;
            for(int j=1;j<=n;j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j-1],Math.min(diagUp,dp[j]));
                } else dp[j] = 0;
                diagUp = temp;
                ans = Math.max(ans,dp[j]);
            }
        }
        return ans*ans;
    }
}