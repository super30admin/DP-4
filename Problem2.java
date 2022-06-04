//Time Complexity: O(NK)
//Space Complexity: O(N) ELEMENTS
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            int max = arr[i];
            for(int j = i;j >= (i-k + 1);j--){
                if(j >= 0){
                max = Math.max(max,arr[j]);
                if(j > 0){
                    dp[i] = Math.max(dp[i], max * (i-j+1) + dp[j-1]);
                }
                else{
                    dp[i] = Math.max(dp[i], max * (i-j+1));
                }
            }
        }
        }
              return dp[dp.length - 1];
    }
}