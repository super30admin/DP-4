// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we'll memorize the maximum sum obtained from 1 to k partitions at each index, then will add that sum 
//to calculate maximum obtainable sum from 1 to k partitions in next indices

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && (i - j + 1 >= 0); j++) {
                max = Math.max(max, arr[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], (max * j) + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], (max * j));
                }
            }
        }
        return dp[n - 1];
    }
}