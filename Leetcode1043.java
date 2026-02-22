// Solution : DP Approach
// TC - O(n*k) - iterate over array and for each element iterate k times.
// SC - O(n) - DP array space.
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];
        int dp[] = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int maxPartitionValue = arr[i];
            for (int j = 0; j < k && i - j >= 0; j++) { // iterate k times for each element.
                maxPartitionValue = Math.max(maxPartitionValue, arr[i - j]); // find max value in current partition.
                int currentValue = (j + 1) * maxPartitionValue; // calculate current partition value.
                if (i - j > 0) { // add previous partition value to current partition value.
                    currentValue += dp[i - j - 1]; // add previous partition value to current partition value.
                }
                dp[i] = Math.max(dp[i], currentValue); // update dp[i] with max value between current dp[i] and current
                                                       // partition value.
            }
        }
        return dp[n - 1];
    }

}