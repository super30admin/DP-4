// Time Complexity: O(N * K)
// Space Complexity: O(N)
// Passed Leetcode

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int[] dp = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++)
        {
            
            int curr_max = 0;
            for (int j = 1; j <= k; j++)
            {
                if (i - j + 1 >= 0)
                {
                    curr_max = Math.max(curr_max, arr[i - j + 1]);
                    dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + curr_max * j);
                }
            }
            
            
        }
        
        return dp[arr.length - 1];
    }
}