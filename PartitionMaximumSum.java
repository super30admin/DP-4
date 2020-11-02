// Time:O(N*K)
// Space:O(N) 
//create a dp array with the max subarray value for each element

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int size = arr.length;
        int[] dp = new int[size];

        for (int i = 0; i < size; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);

                if (i >= j) {
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j); // [1 ,15, 7 ] 0 + 15 * 3
                }
                dp[i] = Math.max(dp[i], max * j); // [1, 15, 7 ] 7 + 15 * 15
            }
        }
        
        return dp[size - 1];
    }
}
