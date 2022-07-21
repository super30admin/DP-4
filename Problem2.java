// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//1043. Partition Array for Maximum Sum
//https://leetcode.com/problems/partition-array-for-maximum-sum/

class Solution {
    // DP
    // time: O(nk)
    // space: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        if (n == 0)
            return 0;
        // dp array
        int[] dp = new int[n];

        int max = -1;
        int maxValue = -1;
        // Iterate over the array and at each element calculate the max sum possible
        // with k partitions
        // To calculate the max sum possible with k partitions at each element,
        // find Math.max(maximum of all partitions possible at an element with the ones
        // before)
        // at each partition - maximum of partition not calculated + partition
        // calculated prevoously
        // m=0,1,2...k //arr[i-m] //max*length (max is calculated by comparing current
        // max with new incoming element and length is the increment, the first max is
        // the element itself)
        for (int i = 0; i < n; i++) {

            if (i == 0) {
                dp[i] = arr[i];
            }
            int m = 0;
            int len = 1;
            int maxEle = arr[i];

            if (i < k && i > 0) {
                while (m <= i) {

                    maxEle = Math.max(maxEle, arr[i - m]);
                    max = len * maxEle;
                    if (m == i) {
                        dp[i] = Math.max(max, dp[i]);
                    } else {
                        dp[i] = Math.max(max + dp[(i - 1) - m], dp[i]);
                    }
                    len++;
                    m++;
                }
            } else if (i >= k) {
                while (m < k) {
                    maxEle = Math.max(maxEle, arr[i - m]);
                    max = len * maxEle;
                    dp[i] = Math.max(max + dp[(i - 1) - m], dp[i]);

                    len++;
                    m++;
                }
            }

            maxValue = Math.max(maxValue, dp[i]);
        }

        // for(int i=0; i<n; i++){
        // System.out.println(dp[i]);
        // }
        return maxValue;
    }
}