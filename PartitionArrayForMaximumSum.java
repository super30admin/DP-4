// Time Complexity : O(n*k).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We performed bottom up recursion and maintained the max sum possible for each index in a dp array. We return the last element in the dp array
// as it stores the max possible sum. At each index we calculate the maximum number in the partition and compute the max sum obtained by all combinations
// and store it at the index value.

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int maxInPartition = 0;

            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxInPartition = Math.max(maxInPartition, arr[i - j + 1]); //compute the max value in partition size

                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], maxInPartition * j + dp[i - j]); // to capture the max sum possible in the partition
                } else {
                    dp[i] = Math.max(dp[i], maxInPartition * j);
                }
            }
        }

        return dp[n - 1];
    }
}