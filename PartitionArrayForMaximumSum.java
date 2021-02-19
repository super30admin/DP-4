// TC: O(N*K)
// SC: O(N)
// Did it run successfully On Leetcode? : Yes
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if ( arr == null || arr.length == 0)
            return 0;
        int[] dp = new int[arr.length];
        for ( int i = 0; i < arr.length; i++)   // O(N)
        {
            int max = arr[i];
            for ( int j = 1; j <= k && i-j+1 >=0 ; j++)  // O(K)
            {
                max = Math.max(max, arr[i-j + 1]);
                if (i-j >= 0 )
                {
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                }
                else
                {
                     dp[i] = Math.max(dp[i], max * j);
                }     
            }
        }
        return dp[arr.length-1];
    }
}
