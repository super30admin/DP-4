//Time: O(n*k)
//Space: O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];  // DP array to store the maximum sum for each subarray ending at i

        // Iterate over every position in the array
        for (int i = 0; i < n; i++) {
            int maxElement = arr[i];  // Track the maximum element in the current partition

            // Look back up to k elements
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                // Update maxElement for the current partition
                maxElement = Math.max(maxElement, arr[i - j + 1]);
                
                // Update dp[i] by considering the current partition
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + maxElement * j);
                } else {
                    dp[i] = Math.max(dp[i], maxElement * j);  // Case when partition starts from the beginning
                }
            }
        }

        // The result is stored in dp[n-1]
        return dp[n - 1];
    }
}
