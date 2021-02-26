// Time Complexity :O(nk)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class PartitionArrayForMaximumSum {

    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;

            //create dp array and initialize dp[0] and max variable
            int[] dp = new int[n];
            dp[0] = arr[0];
            int max = arr[0];

            for (int i = 1; i < k ; i++) {
                max = Math.max(max, arr[i]);//get max value while iterating
                dp[i] = max * (i+1);//dp[i] = max * subarray
            }

            //compute subarray max value
            for (int i = k; i < n ; i++) {
                int subArrayMax = arr[i];
                for (int subArraySize = 1; subArraySize <= k ; subArraySize++) {
                    subArrayMax = Math.max(subArrayMax, arr[i - subArraySize + 1]);
                    dp[i] = Math.max(dp[i], dp[i-subArraySize] + subArrayMax * subArraySize);
                }
                
            }
            return dp[n-1];
        }
    }

}
