// Time Complexity : O(nk) where n is the number of elements and k is the size of the window
// Space Complexity : O(n) for dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Exhaustively finding the maximum sum for each window size [1, k] starting from 0th index and comparing the maximum sum.
 */
class RecursiveSolution {
    int[] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return helper(arr, 0, k);
    }

    private int helper(int[] arr, int i, int k) {
        if (i >= arr.length) return 0;

        if (memo[i] != -1) return memo[i];

        int maxInPartition = 0;
        int max = 0;
        // starting with partition size 1 and calculating the sum for maximum element within first window
        for (int j = 1; j <= k && i + j - 1 < arr.length; j++) {
            maxInPartition = Math.max(maxInPartition, arr[i + j - 1]);
            int partitionSum = maxInPartition * j;
            // exhaustively getting maximum sum for all windows and comparing the max
            max = Math.max(max, partitionSum + helper(arr, i + j, k));
        }

        memo[i] = max;
        return max;
    }
}

// Time Complexity : O(nk) where n is the number of elements and k is the size of the window
// Space Complexity : O(n) for dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using tabulation dp to calculate the maximum sum for each index and saving the result in dp array to reference in subsequent iterations.
 */
class TabulationSolution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int maxInPartition = 0;
            int max = 0;
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxInPartition = Math.max(maxInPartition, arr[i - j + 1]);
                int currPartition = maxInPartition * j;
                int total = currPartition;
                if (i - j >= 0) {
                    total += dp[i - j];
                }
                max = Math.max(max, total);
            }
            dp[i] = max;
        }

        return dp[n - 1];
    }
}