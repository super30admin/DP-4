// Time Complexity : O(n ^ 2)
// Space Complexity : O(n ^ 2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length + 1;
        int n = matrix[0].length + 1;
        int[][] dp = new int[m][n];
        int result = Integer.MIN_VALUE;
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i-1][j-1] == '0') {
                    dp[i][j] = 0;
                } else {
                    int maxSquare = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    dp[i][j] = maxSquare;
                    result = Math.max(result, maxSquare);
                }
            }
        }
        return result * result;
    }
}