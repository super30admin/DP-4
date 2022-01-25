// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this using dp
// we create a dp array
// We loop through the given array and with help of j and k we partition it and store the max value uptill that point in the dp array

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[arr.length - 1];
    }
}