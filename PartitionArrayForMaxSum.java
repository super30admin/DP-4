// Bottom Up DP TC = O(KN)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];
        for(int i=1;i<len;i++){
            int max = arr[i];
            for(int j=1;j<=k && i-j+1>=0;j++){
                max = Math.max(max,arr[i-j+1]); //i-j+1 is the incoming element
                if(i-j>=0){
                    dp[i] = Math.max(dp[i],max*j + dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i],max*j);
                }
                
            }
        }
        return dp[len-1];
    }
}

