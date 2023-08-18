// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes




class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0, k, dp);
    }

    private int helper(int[] arr, int ind, int k, int[] dp) {
        if (ind >= arr.length) return 0;
        if(dp[ind] != -1) return dp[ind];

        int maxSum = 0, maxValue = 0;
        for (int i = ind; i < Math.min(ind + k, arr.length); i++) {
            maxValue = Math.max(maxValue, arr[i]);
            maxSum = Math.max((i - ind + 1) * maxValue + helper(arr, i + 1, k, dp), maxSum);
        }

        return dp[ind] = maxSum;
    }
}

