// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used a dp array which basically stores the max amount that can be made with current number of elements and partitions of size k. For eg dp[i] tells the max amount we can make using only elements up till ith index. I keep the dp[0] same as arr[0]. From every other point, I go back k steps and check the maximum value - once I have it, I can make all elements the max and use the max sum from dp for all elements before, or I can just leave it as it is. If I choose to use max, then length of current partition will be i-j+1 and max sum will be length * max + maxSum for all before start of this partition. At the end I just return dp[n-1] as it represents the overall max sum.

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int j = i; j >= 0 && i - j + 1 <= k; j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], max * (i - j + 1) + (j > 0 ? dp[j - 1] : 0));
            }
        } 
        return dp[n - 1];
    }
}
