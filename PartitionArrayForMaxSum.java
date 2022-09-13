public class PartitionArrayForMaxSum {
    //Time Complexity: O(n)
    //Space: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                int currPart = max * j;
                if (i - j >= 0) {
                    currPart = max * j + dp[i - j];
                }

                dp[i] = Math.max(dp[i], currPart);
            }
        }
        return dp[n - 1];
    }
}
