//Time Complexity - O(k*n)
//Space Complexity - O (n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //edge case
      if(arr == null || arr.length == 0) return 0;
      int[] dp = new int[arr.length];
      //fisrt element and 1 partition 
      dp[0] = arr[0];
      for(int i = 1;i < dp.length;i++) { 
        int max = arr[i];
        for(int j = 1; j<=k ; j++) { //partition from 1 to k
          if(i-j+1 >= 0) {
            max = Math.max(max, arr[i-j+1]); // max between incoming number and prev max
            if(i-j >= 0) {
              dp[i] = Math.max(dp[i],dp[i-j] + max*j);
            } else {
              dp[i] = Math.max(dp[i],max*j) ;
            }
          }
        }
      }
        return dp[arr.length-1];
      }
}