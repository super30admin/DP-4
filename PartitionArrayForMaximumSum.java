// Time Complexity : O(n * k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use DP with memoization to solve this problem by taking a memo array and initially fill with -1. Now,
we take a helper method to compute curr maximum value starting from j upto k. Once we find a larger value, we
need to multiple it k times(i.e., j times) and add it to the recursive sum that builds with next i + j values
and find the maximum between them. Store/memoize this max value in the array to optimize or refer.
 */
class Solution {
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return helper(arr, k, 0);
    }

    private int helper(int[] arr, int k, int i) {
        if(i == arr.length) {
            return 0;
        }

        if(memo[i] != -1)
            return memo[i];

        int max = 0;
        int currMax = 0;
        for(int j = 1 ; j <= k && i + j - 1 < arr.length ; j++) {
            currMax = Math.max(currMax, arr[i + j - 1]);
            max = Math.max(max, currMax * j + helper(arr, k, i + j));
        }
        memo[i] = max;
        return max;
    }
}