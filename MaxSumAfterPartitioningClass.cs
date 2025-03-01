public class Solution
{
    public int MaxSumAfterPartitioning(int[] arr, int k)
    {
        if (arr == null || arr.Length == 0 || k == 0)
        {
            return 0;
        }

        int n = arr.Length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++)
        {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++)
            {
                max = Math.Max(max, arr[i - j + 1]);
                if (i - j >= 0)
                {
                    dp[i] = Math.Max(dp[i], dp[i - j] + j * max);
                }
                else
                {
                    dp[i] = Math.Max(dp[i], j * max);
                }

            }
        }
        return dp[n - 1];
    }
}