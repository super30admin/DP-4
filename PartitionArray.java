// Time Complexity: O(k^n), n - array size
// Space Complexity: O(n), recursion stack size
// Did this code successfully run on Leetcode : no, TLE
// Any problem you faced while coding this : forgot the DP approach
// Approach:
// 1. Exhaustive recursion, try all possible partition
// 2. Calculate the sum at each partition
// 3. Find the maxSum from the sum when currIdx reaches end of the array

public class PartitionArray {
    int max = 0;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        helper(arr, k, 0, 0);
        return max;
    }

    void helper(int[] arr, int k, int i, int sum) {

        if(i >= arr.length) {
            max = Math.max(max, sum);
            return;
        }

        int maxSum = 0;
        for(int j=1; j<=k && i+j <= arr.length; j++) {
            maxSum = Math.max(maxSum, arr[i + j - 1]);
            helper(arr, k, i+j, sum + (j * maxSum));
        }
    }
}
