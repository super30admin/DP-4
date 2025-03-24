import java.util.Arrays;

// DP: Memoization
// TC: O(n*k)
// SC: O(n)
public class PartitionArrayforMaximumSum {
    private int solve(int arr[], int i, int k, int n, int dp[]) {
        // BC
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        // Logic
        int maxEl = 0, maxSum = 0;
        for (int x = i; x < Math.min(n, i + k); x++) {
            maxEl = Math.max(maxEl, arr[x]);
            maxSum = Math.max(maxSum, (maxEl * (x - i + 1)) + solve(arr, x + 1, k, n, dp));
        }
        return dp[i] = maxSum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(arr, 0, k, n, dp);
    }
}

// DP: Tabulation
// TC: O(n*k)
// SC: O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int maxEl = 0, maxSum = 0;
            for (int x = i; x < Math.min(n, i + k); x++) {
                maxEl = Math.max(maxEl, arr[x]);
                maxSum = Math.max(maxSum, (maxEl * (x - i + 1)) + dp[x + 1]);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }
}