class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            int max=arr[i];
            for(int j=0;j<k && i-j>=0;j++){
                max=Math.max(arr[i-j],max);
                if(i-j>0){
                    dp[i]=Math.max(dp[i],max*(j+1)+dp[i-j-1]);
                }
                else{
                    dp[i]=max*(j+1);
                }
            }
        }
        return dp[dp.length-1];
    }
}
