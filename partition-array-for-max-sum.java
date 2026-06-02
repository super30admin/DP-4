// Time Complexity : O(n * k) because for every index we try partitions of size up to k
// Space Complexity : O(n) for the DP array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Dynamic Programming where dp[i] stores the maximum sum obtainable from the first i+1 elements.
// For every index, we try all partition sizes from 1 to k and track the maximum value inside the current partition.
// The answer for each partition is computed as partitionMax * partitionLength plus the best answer before that partition.

class Solution {

    public int maxSumAfterPartitioning(
        int[] arr,
        int k
    ) {

        int n = arr.length;

        // dp[i] = max sum for first i+1 elements
        int[] dp = new int[n];

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {

            // max element in current partition
            int currMax = 0;

            // try partition sizes 1 to k
            for (
                int j = 1;
                j <= k &&
                i - j + 1 >= 0;
                j++
            ) {

                // update partition maximum
                currMax = Math.max(
                    currMax,
                    arr[i - j + 1]
                );

                // partition has previous portion
                if (i - j >= 0) {

                    dp[i] =
                        Math.max(
                            dp[i],
                            currMax * j +
                            dp[i - j]
                        );
                }

                // partition starts from index 0
                else {

                    dp[i] =
                        Math.max(
                            dp[i],
                            currMax * j
                        );
                }
            }
        }

        return dp[n - 1];
    }
}