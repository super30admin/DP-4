// TC: O( k ^ N)
// SC: O(N)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if (i - j >= 0) {

                    dp[i] = Math.max(max * j + dp[i - j], dp[i]);
                } else {
                    dp[i] = Math.max(max * j + 0, dp[i]);
                }
            }
        }
        return dp[n - 1];
    }
}