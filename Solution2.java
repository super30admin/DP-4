//TimeC:O(n.k)
//SC:O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];         
        for (int i = n - 1; i >= 0; i--) {
            int best = 0, curMax = 0;
            for (int len = 1; len <= k && i + len <= n; len++) {
                curMax = Math.max(curMax, arr[i + len - 1]); // max in current block
                int candidate = curMax * len + dp[i + len];  // block sum + best of remainder
                best = Math.max(best, candidate);
            }
            dp[i] = best;
        }
        return dp[0];
    }
}