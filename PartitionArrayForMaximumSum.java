public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n + 1]; //base: dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int len = 1; len <= k && i - len >= 0; len++) {
                max = Math.max(max, arr[i - len]);
                dp[i] = Math.max(dp[i], dp[i - len] + max * len);
            }
        }
        return dp[n];
    }
}

//TC: O(n*k), SC: O(n)
