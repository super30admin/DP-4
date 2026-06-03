// Time Complexity : O(N*K) where N is the length of the input array and K is the maximum partition size
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Brute force approach would be to iterate through the array and for each index, we would try to partition the array into all possible sizes from 1 to k and calculate the sum for each partition.
//  We would keep track of the maximum sum found so far and return it at the end. It has repeated sub problems as we are calculating the sum for the same index multiple times, 
// but we are not storing the results of those sub problems, hence it is not a dynamic programming solution.

// Dynamic programming approach would be to use a memoization array to store the results of the sub problems. 
// We would initialize the memoization array with -1 to indicate that the result for that index has not been calculated yet.
// We would then define a helper function that takes the input array, the current index and the
// maximum partition size as parameters. The helper function would check if the current index is greater than or equal to the length of the input array, 
// in which case it would return 0.
// If the result for the current index is already calculated and stored in the memoization array,
class Solution {

    int[] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {

        memo = new int[arr.length];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return helper(arr, 0, k);
    }

    private int helper(int[] arr, int i, int k) {

        if (i >= arr.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int maxSum = 0;
        int currMax = 0;

        for (int j = 1; j <= k && i + j <= arr.length; j++) {

            currMax = Math.max(currMax, arr[i + j - 1]);

            int currSum = currMax * j + helper(arr, i + j, k);

            maxSum = Math.max(maxSum, currSum);
        }

        memo[i] = maxSum;
        return maxSum;
    }
}