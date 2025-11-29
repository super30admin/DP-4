// Time Complexity : O(nk)
// Space Complexity :O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : i am a bit fuzzy on the logic.

/*
this is the tabulation solution

we are using the dp to calculate what will be the max value at that index from left to right
we take maxInPartition as assume arr[i] is at max then loop thorugh all the posible value find the max value an update that in the dp matrix
i - j + 1 this is for out of bound check

*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int maxInPartition = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxInPartition = Math.max(maxInPartition, arr[i - j + 1]);
                int curPartition = maxInPartition * j;
                if (i - j >= 0) {
                    curPartition += dp[i - j];
                }
                dp[i] = Math.max(dp[i], curPartition);
            }
        }
        return dp[n - 1];
    }
}