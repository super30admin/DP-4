// In this problem using dp, storing the maximum sum for each subproblem into the dp array. 

// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Base
        if (arr == null || arr.length == 0 || k == 0) {
            return 0;
        }
        int n = arr.length;
        // Dp array
        int[] dp = new int[n];
        // First value will be first value only because, maximum sum of 1 element is
        // that element only
        dp[0] = arr[0];
        // Loop from 1 to n now
        for (int i = 1; i < n; i++) {
            // Make the current element as the max element
            int max = arr[i];
            // Now including the current element we can make at most k partition, so run a
            // loop for 1 to k, so it will be picking only that element, then picking 2
            // elements, then 3
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                // Change the max value accordingly, if current element is 5 and previous
                // element is 9 and we are at j=2, that is picking length 2, then max of (9,5)
                // should be 9
                // We get the incoming element by i-j+1
                max = Math.max(max, arr[i - j + 1]);
                // Then calculate the max sum for current element and store it in dp array
                if (i - j >= 0) {
                    // New sum will be (max sum of previous subproblem + partition length * max)
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j);
                } else {
                    // If no previous subproblem, simply partition length * max
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        // Our max sum will be at last place
        return dp[n - 1];
    }
}