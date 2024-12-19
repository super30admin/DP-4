class Solution {
    //TC:O(N*K)
    //SC : O(N)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int m = arr.length;
        int[] dp = new int[m];
        dp[0] = arr[0];

        for(int i=1;i<m;i++){
            int max = arr[i];
            //j is number of partition 1,2,3,--k
            for(int j=1;j<=k && i-j+1>=0 ;j++){
                max = Math.max(max,arr[i-j+1]);
                if(i-j>=0){
                    dp[i] = Math.max(dp[i],max*j+dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i],max*j);
                }

            }
        }
        return dp[m-1];
    }
}