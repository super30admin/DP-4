// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int currPartMax = arr[i];
            // make all the possible partions
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                currPartMax = Math.max(currPartMax, arr[i - j + 1]);
                int currSum = (currPartMax * j);
                if (i - j >= 0) {
                    currSum += dp[i - j];
                }
                dp[i] = Math.max(dp[i], currSum);
            }
        }
        return dp[n - 1];
    }
}