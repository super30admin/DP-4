class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = -999;
            for (int j = 1; (j <= K) && (i - j + 1 >= 0); j++) {
                max = Math.max(max, A[i - j + 1]);

                if (i >= j) {
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j);
                }
                dp[i] = Math.max(dp[i], max * j);
            }
        }
        return dp[n - 1];
    }
}
// Time:O(N^2)
// Space:O(N)