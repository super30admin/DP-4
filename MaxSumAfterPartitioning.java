// Problem 1043. Partition Array for Maximum Sum
// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int maxInPartition = 0;
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxInPartition = Math.max(maxInPartition, arr[i - j + 1]);
                int currentSum = maxInPartition * j;
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + currentSum);
                } else {
                    dp[i] = Math.max(dp[i], currentSum);
                }
            }
        }
        return dp[n - 1];
    }
}
