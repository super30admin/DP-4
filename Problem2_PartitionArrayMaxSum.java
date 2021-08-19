// Time Complexity : o(nk)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach\

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        if(arr==null||arr.length==0||k==0)
            return 0;
        
        int[] dp=new int[arr.length];
        
        dp[0]=arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
           int max=arr[i];
            
            for(int j=1;j<=k && i-j+1>=0;j++)
            {
                max=Math.max(max,arr[i-j+1]); //incoming element
                
                if(i-j>=0)
                {
                    dp[i]=Math.max(dp[i],dp[i-j]+max*j);
                    
                }
                else
                {
                   dp[i]=Math.max(dp[i],max*j);
                }
            }
        }
        return dp[arr.length-1];
    }
}