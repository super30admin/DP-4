// TC => O(m*n)
// SC => O(m*n)

public class Solution
{
    public int MaximalSquare(char[][] matrix)
    {
        if (matrix == null || matrix.Length == 0)
        {
            return 0;
        }

        int m = matrix.Length, n = matrix[0].Length;
        int[][] dp = new int[m + 1][];
        for (int i = 0; i <= m; i++)
        {
            dp[i] = new int[n + 1];
        }

        int max = 0;
        for (int i = 1; i < m + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                if (matrix[i - 1][j - 1] == '0')
                {
                    continue;
                }
                dp[i][j] = Math.Min(dp[i - 1][j], Math.Min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                max = Math.Max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}