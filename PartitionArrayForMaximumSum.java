public class PartitionArrayForMaximumSum {
    // TC: O(N * K) where N is length of array
    // SC: O(N) where N is length of array
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int maxInSubArray = Integer.MIN_VALUE;
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxInSubArray = Math.max(maxInSubArray, arr[i - j + 1]);
                int currVal = j * maxInSubArray;
                if (i - j >= 0) {
                    currVal += dp[i - j];
                }
                dp[i] = Math.max(dp[i], currVal);
            }
        }
        return dp[n - 1];
    }
}
