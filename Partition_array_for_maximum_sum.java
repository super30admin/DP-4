
//Approach:
//1. We will find all the sub arrays of size K starting from 1, and we do this from each i backwards, find the max value in each sub array that we consider and update the max. 
//2. Keep filling the dp array with the max value and for all value upto K.
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0)
            return 0;
        int[] dp = new int[A.length];
        for(int i=0;i< A.length;i++)
        {
            int max = A[i];
            for(int j=1;i-j+1>=0 && j<=K;j++)
            {
                max = Math.max(max, A[i-j+1]);
                if(i - j >= 0)
                {
                    dp[i] = Math.max(dp[i], max * j + dp[i-j]);
                }else
                {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        
        return dp[A.length-1];
    }
}
//Time Complexity : O(nK), where n is the size of the array 
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
