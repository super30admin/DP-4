//Time Complexity : O(Nk), n -> Length of array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        if( n == 0 || arr == null || k == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1; i < n; i++) {

            int max = arr[i];

            for(int j = 1; j <= k && i-j+1 >= 0; j++)  {
                max = Math.max(max, arr[i-j+1]);
                if(i-j >= 0)
                    dp[i] = Math.max(dp[i], dp[i-j]+max*j);
                else
                    dp[i] = Math.max(dp[i], max*j);
            }
        }
        return dp[n-1];
    }
}