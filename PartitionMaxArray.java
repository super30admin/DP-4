class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int currMax=arr[i];
            for(int j=1;j<=k && i-j+1>=0 ;j++){
                currMax=Math.max(currMax,arr[i-j+1]);
                if(i-j>=0){
                    dp[i]=Math.max(dp[i],currMax*j+dp[i-j]);
                }else{
                    dp[i]=Math.max(dp[i],currMax*j);
                }
            }
        }
        return dp[n-1];
    }
}