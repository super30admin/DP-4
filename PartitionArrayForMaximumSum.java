// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class PartitionArrayForMaximumSum {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] dp = new int[n];
            dp[0] = arr[0];
            for(int i=0; i<n; i++) {
                int max = arr[i];
                for(int j = 1; j <= k && i - j + 1 >= 0; j++) {
                    max = Math.max(max, arr[i-j+1]);//15
                    if(i-j >= 0){
                        dp[i] = Math.max(dp[i], (max*j) + dp[i-j]);
                    } else{
                        dp[i] = Math.max(dp[i], max*j);
                    }

                }
            }

            return dp[n - 1];
        }
    }
}
