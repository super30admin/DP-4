// Time Complexity : O(N*K)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        
        
        for(int i=1;i<arr.length;i++){
            
            int max=arr[i];
            
            for(int p=1;p<=k;p++){
                
                if((i-p)<0){
                    dp[i]=Math.max(dp[i],p*max);
                    break;
                }
                dp[i]=Math.max(dp[i],dp[i-p]+p*max);
                max=Math.max(max,arr[i-p]);
            }
          
        }
        
        return dp[dp.length-1];
    }
}