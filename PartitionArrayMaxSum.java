/**
 Time Complexity - O(nk)
 Space Complexity - O(n)
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i=1; i<n;i++) {
            int currMax = arr[i];
            for (int j=1; j <= k && i-j+1>=0 ; j++) {
                currMax = Math.max(currMax, arr[i+1-j]);
                if (i-j >=0) {
                    dp[i] = Math.max(dp[i], j*currMax + dp[i-j]);
                } else {
                    dp[i] = Math.max(dp[i], j*currMax);
                }
            }
        }
        return dp[n-1];
    }
}