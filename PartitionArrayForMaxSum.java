//bottom up dp
class PartitionArrayForMaxSum {
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int[arr.length];
        dp[0]=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            int max=0;
            for(int j=1;j<=k && i-j+1>=0;j++)
            {
                max=Math.max(max,arr[i-j+1]);
                if(i-j<0)
                {
                    dp[i] = Math.max(dp[i], max*j+0);
                }
                else{
                    dp[i] = Math.max(dp[i], max*j+dp[i-j]);
                }
                
            }
        }
        return dp[arr.length-1];
    }
    
}

//Time Complexity (TC): O(n * k), where n is the length of the input array arr, and k is the maximum partition size.
//Space Complexity (SC): O(n)