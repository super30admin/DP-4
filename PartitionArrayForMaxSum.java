// TC: O(n * k); n = arr.length
// SC: O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i ++) {
            int maxInPartition = 0;
            for (int j = 1; j <= k && i - j + 1 >= 0; j ++) {
                // Include a number in the partition and get max of partition
                maxInPartition = Math.max(maxInPartition, arr[i - j + 1]);
                // Add max sum until previous partition
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], maxInPartition * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], maxInPartition * j);
                }
            }
        }
        return dp[arr.length - 1];
    }
}