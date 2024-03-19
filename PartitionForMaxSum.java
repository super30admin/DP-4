// Time: O(n * k)
// Space: O(n)

// Approach: Use bottom up dp. If there are x values, the answer depends on
// all possible parititons with that particular index + the last value.

public class PartitionForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // max partition sum
            int currentMax = arr[i] + dp[i - 1];
            // max number as k is increasing
            int max = arr[i];
            for (int j = 1; j < k && i - j >= 0; j++) {
                int curr = 0;
                max = Math.max(max, arr[i - j]);
                curr = max * (j + 1);
                // max of remaining value
                if ((i - j - 1) >= 0) {
                    curr += dp[i - j - 1];
                }
                currentMax = Math.max(currentMax, curr);
                System.out.println(currentMax);
            }
            dp[i] = currentMax;
        }

        return dp[arr.length - 1];
    }
}
