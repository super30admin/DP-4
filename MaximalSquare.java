/**
Time Complexity : O(M*N)
Space Complexity : O(M*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution {
    public int maximalSquare(char[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int [m + 1][n + 1];
        
        int max = 0;

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    int min = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    dp[i][j] = 1 + min;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max*max;
    }
}