class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) {
            return 0;
        }

        int n = arr.length;
        
        // both works.

        int dp[] = new int[n];

        dp[0] = arr[0];

        for (int i = 1; i < n; ++i) {
            int max = arr[i];
            for (int j = 1; j <= k; ++j) {
                if ((i - j + 1) >= 0) {
                    max = Math.max(max, arr[i - j + 1]);
                    dp[i] = Math.max(dp[i], ((i - j) >= 0 ? dp[i - j] : 0) + (j * max));
                }
            }
        }
        return dp[n - 1];

        // int dp[] = new int[n + 1];

        // dp[1] = arr[0];

        // for (int i = 1; i < n; ++i) {
        //     int max = arr[i];
        //     for (int j = 1; j <= k; ++j) {
        //         if ((i - j + 1) >= 0) {
        //             max = Math.max(max, arr[i - j + 1]);
        //             dp[i + 1] = Math.max(dp[i + 1], dp[i + 1 - j] + (j * max));
        //         }
        //     }
        // }
        // return dp[n];
    }
}