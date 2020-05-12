// Time Complexity : O(nk)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No
public class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        int [] dp = new int[A.length];
        for(int i= 0 ; i <dp.length;i++)
        {
            int max = 0;
            for(int j = 1; i-j+1 >=0 && j <=K;j++ )
            {
                max = Math.max(max, A[i-j+1]);
                if(i>=j)
                {
                    dp[i] = Math.max(dp[i],max * j + dp[i-j]);
                }
                else
                {
                    dp[i] = Math.max(dp[i],max * j + 0);
                }
            }
        }
        return dp[A.length-1];
        
    }
}class MaximalSum {
    
}