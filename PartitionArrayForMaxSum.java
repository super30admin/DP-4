/*
 * TC: O(nk)
 * SC: O(n)
 */
public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int max = arr[i];
            // we expand from arr[i] back up to k elements
            // (or the start of the array)
            for (int j = 1; j <= Math.min(i + 1, k); j++) {
                // we update the max element in the subarray
                // based on the new element coming in
                max = Math.max(max, arr[i - j + 1]);
                // update the max sum at i based on the below formula
                dp[i] = Math.max(dp[i], (i - j >= 0 ? dp[i - j] : 0) + j * max);
            }
        }
        return dp[n - 1];
    }
}
