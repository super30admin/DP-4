class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n=arr.length;
        int[] dp=new int[n];
        
        int max=-1;
        
        for(int i=0;i<k;i++)
        {
            max=Math.max(max,arr[i]);
            dp[i]=max*(i+1);
        }
        
        max=-1;
        for(int i=k;i<n;i++)
        {
            max=arr[i];
            for(int j=0;j<k;j++)
            {
                max=Math.max(max,arr[i-j]);
                dp[i]=Math.max(dp[i],dp[i-j-1]+max*(j+1));
                
            }
        }
        
        return dp[n-1];
        
    }
}

// Time Complexity : O(N*K)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
