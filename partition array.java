//Timecomplexity;-O(n)
//Spacecomplexiy:-O(n)



class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length];
        for(int i=0;i<dp.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<=k && i-j+1>=0;j++){
                max=Math.max(arr[i-j+1],max);
                if(i>=j){
                    dp[i]=Math.max(dp[i],max*j + dp[i-j]);
                }
                else{
                    dp[i]=Math.max(max*j,dp[i]);
                }
                
            }
        }
        return dp[dp.length-1];
    }
}