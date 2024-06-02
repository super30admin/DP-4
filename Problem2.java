package DP-4;

// TC: O(k*n)
// SC: O(n)
public class Problem2 {
    
   
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int m = arr.length;
        int[] dp = new int[m];
        dp[0] = arr[0];
        for (int i = 1; i < m; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(arr[i - j + 1], max);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[m - 1];
    }
}
