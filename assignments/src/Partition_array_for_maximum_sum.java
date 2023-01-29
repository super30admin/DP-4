// IMP to note: Greedy approach will fail. Use DP.
// Approach: DP, we calculate max values of all possible partitions as we iterate over the elements
// We keep storing the Max sum at each index in the dp[] array to calculate next dp[] elements
// Time: O(n)
// Space: O(n)
class Partition_array_for_maximum_sum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i<n; i++) {
            int max = arr[i];

            // checking i-j+1 >= 0 is IMP as we cannot look at index -1
            for (int j = 1; j <= k && i-j+1 >= 0; j++) {
                // [i-j+1] will be the incoming element towards left
                max = Math.max(max, arr[i-j+1]);
                int currVal = max*j;

                if (i - j >= 0) {           // since we cannot get value of dp[index-1]
                    currVal += dp[i-j];
                }
                dp[i] = Math.max(dp[i], currVal);
            }
        }
        return dp[n-1];
    }
}