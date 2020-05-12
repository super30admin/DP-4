// Time complexity: O(N*K) where N is the length of array and K is the length of subarray
// Space complexity: O(N) length of array

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {    
        int[] dp = new int[A.length];
        // dp[0] = A[0];
        for(int i = 0; i < A.length; i++)
        {
            int max = 0;
            for(int j = 1; i-j+1 >=0 && j <= K; j++)
            {
                max = Math.max(max, A[i-j+1]);
                if(i >= j) 
                {
                    dp[i] = Math.max(dp[i], max * j + dp[i-j]);
                }
                else
                {
                    dp[i] = Math.max(dp[i], max*j);
                }
                
            }
        }
        return dp[dp.length - 1];
        
    }
}