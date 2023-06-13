## Problem1:(https://leetcode.com/problems/maximal-square/)

// Time Complexity - 0(m * n)
// Space Complexity - 0(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null && matrix.length == 0) {
            return 0;
        }  
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[] dp = new int[n + 1];

        for (int i = 1; i < m + 1; i++) {
            int temp = dp[0];
            for (int j = 1; j< n + 1; j++) {
                int prev = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(dp[j - 1], Math.min(dp[j], temp));
                    max = Math.max(max, dp[j]);
                    temp = prev;
                }
                else {
                    dp[j] = 0;
                }
            }
        }  
        return max * max;   
    }
}


## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

// Time Complexity - 0(n * k)
// Space Complexity - 0(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return 0;
        }       
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                }
                else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[n - 1];
    }
}