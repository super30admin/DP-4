//time - O(n^2K)
//space - O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i =0; i< arr.length; i++){
            int max = arr[i];
            for(int j =1; j<= k && i-j+1>=0 ; j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j >=0){
                     dp[i] = Math.max(dp[i], (max*j) +dp[i-j]); 
                }else{
                     dp[i] = Math.max(dp[i], max*j); 
                }
            }
        }
        return dp[dp.length-1];
    }
}