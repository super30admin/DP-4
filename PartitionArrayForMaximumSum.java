/**
 * Partition Array for Maximum Sum — LeetCode 1043
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 *
 * Approach:
 * This is a top-down (recursive) dynamic programming solution with memoization.
 * From index i, try all partition lengths up to k. For each partition, track the
 * maximum element in the partition and compute contribution = maxElement * length.
 * Add this to the best result for the remainder of the array (i + length). Memoize
 * results per starting index to avoid recomputation.
 *
 * Time Complexity: O(n * k) where n = arr.length and k is the maximum partition length.
 * Space Complexity: O(n) for the memoization array plus O(n) recursion depth in the worst case.
 */
public class PartitionArrayForMaximumSum {

    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return helper(arr, 0, k);
    }

    private int helper(int[] arr, int i, int k) {
        //base
        if (i >= arr.length) return 0;
        if(dp[i] != null) return  dp[i];
        int maxSum = 0;
        int currMax = 0;

        for (int j = 0; j < k && i + j < arr.length; j++) {
            currMax = Math.max(currMax, arr[i + j]);
            int currSum = (currMax * (j + 1)) + helper(arr, i + j + 1, k);
            maxSum = Math.max(maxSum, currSum);
        }
        dp[i] = maxSum;
        return maxSum;
    }
}
