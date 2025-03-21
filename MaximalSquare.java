// Time Complexity : O(m*n) where m*n is the size of the array.
// Space Complexity : O(m*n).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxSideLen = 0;
        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(matrix[i][j] == '1')
                {
                    dp[i][j] = 1+ Math.min(dp[i+1][j] , Math.min(dp[i+1][j+1], dp[i][j+1]));
                    maxSideLen = Math.max(dp[i][j], maxSideLen);
                }
                else
                dp[i][j] = 0;
            }
        }
        return maxSideLen*maxSideLen;
    }
} 
