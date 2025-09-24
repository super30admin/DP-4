class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int max_no=0;
            for(int j=1;j<=k && i-j+1>=0;j++){
                max_no=Math.max(max_no,arr[i-j+1]);
                if(i-j>=0){
                    //left is present
                    dp[i]=Math.max(dp[i],max_no*j+dp[i-j]);
                }
                else{
                    dp[i]=Math.max(dp[i], max_no* j);
                }
            }
        }
        return dp[n-1];
        
    }
}