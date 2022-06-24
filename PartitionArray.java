/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        
        int length = arr.length;
        int dp[] = new int[length];
        
        for(int i=0; i<length; i++)
        {
            int max = arr[i];
            
            for(int j = 1; j <=k; j++)
            {
                if(i-j+1 >=0)
                {
                    max = Math.max(max, arr[i-j+1]);
                    
                    if(i < j)
                    {
                        dp[i] = Math.max(dp[i], j * max);
                    }
                    else
                    {
                        dp[i] = Math.max(dp[i], dp[i-j] + j * max);
                    }
                }
            }
        }
        
        return dp[length-1];
    }
}