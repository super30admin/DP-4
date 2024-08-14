// Time Complexity: O(nk)
// Space Complexity: O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currMax = 0;
            for (int j = 1; j <= k; j++) {
                if (i - j + 1 >= 0) {
                    currMax = Math.max(currMax, arr[i - j + 1]);
                    int currSumMax = currMax * j;
                    if (i - j >= 0)
                        currSumMax += dp[i - j];
                    dp[i] = Math.max(dp[i], currSumMax);
                }
            }
        }

        return dp[arr.length - 1];

    }
}