class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Tc: O(n*k) Sc: O(n)
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int currentMax = 0;

            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                currentMax = Math.max(currentMax, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i - j >= 0 ? dp[i - j] : 0) + currentMax * j);
            }
        }

        return dp[n - 1];

    }
}