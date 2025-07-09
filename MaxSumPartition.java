
//Time complexity: O(n*k) where n is the length of the array and k is the maximum partition size
//Space complexity: O(n) for the dp array

public class MaxSumPartition {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                int curr = arr[i - j + 1];
                max = Math.max(max, curr);

                if (i - j >= 0)
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                else
                    dp[i] = Math.max(dp[i], max * j + 0);
            }
        }

        return dp[n - 1];
    }
}

// Recursive solution
// Time complexity: O(n*k) where n is the length of the array and k is the
// maximum partition size
// Space complexity: O(n) for the dp array
class MaxSumPartition_Recursive {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr, k, 0);
    }

    private int helper(int[] arr, int k, int idx) {
        // base
        if (idx >= arr.length)
            return 0;

        // logic
        int max = 0;
        int maxInPartition = arr[idx];
        for (int j = 1; j <= k && idx + j - 1 < arr.length; j++) {
            maxInPartition = Math.max(maxInPartition, arr[idx + j - 1]);
            int curr = maxInPartition * j + helper(arr, k, idx + j);
            max = Math.max(max, curr);
        }
        return max;
    }
}

// Recursive solution with memoization
// Time complexity: O(n*k) where n is the length of the array and k is the
// maximum partition size
// Space complexity: O(n) for the dp array
class MaxSumPartition_Recursive_Memoization {
    int[] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.memo = new int[arr.length];
        return helper(arr, k, 0);
    }

    private int helper(int[] arr, int k, int idx) {
        // base
        if (idx >= arr.length)
            return 0;
        if (memo[idx] > 0)
            return memo[idx];

        // logic
        int max = 0;
        int maxInPartition = arr[idx];
        for (int j = 1; j <= k && idx + j - 1 < arr.length; j++) {
            maxInPartition = Math.max(maxInPartition, arr[idx + j - 1]);
            int curr = maxInPartition * j + helper(arr, k, idx + j);
            max = Math.max(max, curr);
        }
        memo[idx] = max;
        return max;
    }
}