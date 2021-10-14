class Solution {
    // TC:O(n) SC:O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < dp.length; i++) {
            int max = dp[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[arr.length - 1];
    }
}