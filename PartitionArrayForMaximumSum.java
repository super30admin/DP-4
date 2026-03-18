/**
 * DP where dp[i] represents max sum for subarray [0..i] by partitioning into chunks of size ≤ k.
 * For each i, try all partition sizes j (1 to k), and use the max element in that window to maximize contribution.
 * Maintains rolling max within window to avoid recomputation.
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(n)
 */
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0]; // Base: only one element, no partition choice

        for(int i = 1; i < n; i++) { 
            int currMax = 0; // Tracks max in current window [i-j+1 ... i]

            // Try all partition sizes ending at i
            for(int j = 1; j <= k && i - j + 1 >= 0; j++) {
                // Expand window backward and update max incrementally (avoids O(k) recompute)
                currMax = Math.max(currMax, arr[i - j + 1]);

                // If previous partition exists, add dp[i-j]; else this is the first partition
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], currMax * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], currMax * j);
                }
            }
        }

        return dp[n - 1];
    }
}