//tc = O(nk)
//sc = O(n)

public class PartitionArrayforMaximumSum {

}

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr.length == 0 || arr == null)
            return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int max = arr[i];
            for (int p = 1; p <= k && i - p + 1 >= 0; p++) {
                max = Math.max(max, arr[i - p + 1]);
                int currVal = max * p;
                if (i - p >= 0) {
                    currVal = currVal + dp[i - p];
                }
                dp[i] = Math.max(dp[i], currVal);
            }
        }
        return dp[n - 1];

    }
}