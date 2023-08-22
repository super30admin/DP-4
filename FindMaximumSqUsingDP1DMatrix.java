// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class FindMaximumSqUsingDP1DMatrix {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[] dp = new int[n+1];

        for(int i=1; i<=m; i++)
        {
            int diagUp = 0;
            for(int j=1; j<=n; j++)
            {
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1')
                {
                    dp[j] = 1+ Math.min(diagUp,Math.min(dp[j],dp[j-1]));
                    max = Math.max(max,dp[j]);
                }else{
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }


        return max*max;

    }
}
