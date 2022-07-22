// Time Complexity : O(NK)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // whatever number comes consider it as maximum
            int max = arr[i];

            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {

                // max between earlier max and Incoming element
                max = Math.max(max, arr[i - j + 1]) ;
                int curr = 0;
                if (i - j >= 0) {
                    curr = max * j + dp[i - j];
                } else {
                    // If not just calculate the value based on max in small window
                    curr = max * j;
                }

                dp[i] = Math.max(dp[i], curr);


            }

        }

        return dp[n - 1];

    }
}