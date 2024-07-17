// Time Complexity : O(N X K)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length; // size
        int[] dp = new int[n]; // new dp array with size same as array size
        dp[0] = arr[0]; // initilizing first element of dp array as first element of the array -> only one element then max is the element itself
        for (int i = 1; i < n; i++) { // starting with 1 as we have already initialized the first element
            int max = arr[i]; // this is the maximum element in the window of j. j = 1, then it is the element i but if j = 2 then the element i and its adjacent. We keep on going till our window length
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]); // in the end max becomes the maximum value of that window of length 4
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + j * max); // adding previous calculated values to current calculation of max
                } else {
                    dp[i] = Math.max(dp[i], j * max); // edge case if we are in the first k elements
                }
            }
        }
        return dp[n - 1]; // last element of the dp array
    }
}