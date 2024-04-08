// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// (https://leetcode.com/problems/partition-array-for-maximum-sum/)

// Algo

import java.util.Arrays;

/**
 * [1, 16, 15, 1, 1, 1, 3]
 * 
 * Greedy Approach:
 * [16, 16, 16, 1, 3, 3, 3] = 58 = not the best possible answer
 * 
 * Go exhaustive:
 * [16, 16, 15, 15, 15, 3, 3] = 83
 * 
 * TC: O(k^n)
 * SC: O(n)
 */
/*
 * Repeated Sub-problems == DP (memoize)
 * 
 * TC: O(nk)
 * SC: O(2n)
 */
/*
 * Tabulation
 * 
 * TC: O(nk)
 * SC: O(n)
 */
public class PartitionArrayMaximumSum_LC_1043 {

    // TLE
    public int maxSumAfterPartitioning_recursion(int[] arr, int k) {
        int n = arr.length;
        return maxSum_recursion(n - 1, arr, k);
    }

    private int maxSum_recursion(int index, int[] arr, int k) {
        // base
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return arr[0];
        }
        // not required
        // if (index == 1) {
        // if (k == 1) {
        // return arr[0] + arr[1];
        // } else {
        // return 2 * Math.max(arr[0], arr[1]);
        // }
        // }
        // logic
        int maxSum = 0;
        int max = arr[index];
        for (int j = 1; j <= k && index - j + 1 >= 0; j++) {
            max = Math.max(max, arr[index - j + 1]);
            maxSum = Math.max(maxSum, max * j + maxSum_recursion(index - j, arr, k));
        }
        return maxSum;
    }

    public int maxSumAfterPartitioning_memoize(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSum_memoize(dp, n - 1, arr, k);
    }

    private int maxSum_memoize(int[] dp, int index, int[] arr, int k) {
        // base
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return arr[0];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        // logic
        int maxSum = 0;
        int max = arr[index];
        for (int j = 1; j <= k && index - j + 1 >= 0; j++) {
            max = Math.max(max, arr[index - j + 1]);
            maxSum = Math.max(maxSum, max * j + maxSum_memoize(dp, index - j, arr, k));
        }
        return dp[index] = maxSum;
    }

    public int maxSumAfterPartitioning_tabulation1(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int index = 1; index < n; index++) {
            int maxSum = 0;
            int max = arr[index];
            for (int j = 1; j <= k && index - j + 1 >= 0; j++) {
                max = Math.max(max, arr[index - j + 1]);
                if (index - j < 0) {
                    maxSum = Math.max(maxSum, max * j);
                } else {
                    maxSum = Math.max(maxSum, max * j + dp[index - j]);
                }
            }
            dp[index] = maxSum;
        }
        return dp[n - 1];
    }

    public int maxSumAfterPartitioning_tabulation2(int[] arr, int k) {
        int n = arr.length;
        // shifting of indices to handle <0 i.e. -1 index
        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        for (int index = 2; index <= n; index++) {
            int maxSum = 0;
            int max = arr[index - 1];
            for (int j = 1; j <= k && index - j >= 0; j++) {
                max = Math.max(max, arr[index - j]);
                maxSum = Math.max(maxSum, max * j + dp[index - j]);
            }
            dp[index] = maxSum;
        }
        return dp[n];
    }

    private class Pair {
        int max;
        int partitionLength;

        Pair(int max, int partitionLength) {
            this.max = max;
            this.partitionLength = partitionLength;
        }
    }

    // Same as House Coloring Pattern
    public int[] maxSumAfterPartitioning_path(int[] arr, int k) {
        int n = arr.length;
        // shifting of indices to handle <0 i.e. -1 index
        int[] dp = new int[n + 1];
        int[] path = new int[n];
        Pair[] maxPartition = new Pair[n];

        dp[1] = arr[0];
        maxPartition[0] = new Pair(arr[0], 1);
        for (int index = 2; index <= n; index++) {
            int maxSum = 0;
            int max = arr[index - 1];
            int maxPartitionLength = 1;

            for (int j = 1; j <= k && index - j >= 0; j++) {
                max = Math.max(max, arr[index - j]);
                if (maxSum < max * j + dp[index - j]) {
                    maxPartitionLength = j;
                    maxSum = max * j + dp[index - j];
                }
            }
            dp[index] = maxSum;
            maxPartition[index - 1] = new Pair(max, maxPartitionLength);
        }

        path[0] = arr[0];
        for (int i = n - 1; i > 0;) {
            Pair pair = maxPartition[i];
            for (int l = 1; l <= pair.partitionLength; l++) {
                path[i] = pair.max;
                i--;
            }
        }
        return path;
    }

}