//Time complexity- O(n * k)
//Space Complexity- O(n)
//Sucessfully ran on leetcode

class Solution {
 public int maxSumAfterPartitioning(int[] arr, int k) {
     if(arr.length==0 || arr== null) return 0;
     
     int n= arr.length;
     int[] dp= new int[n];
     dp[0]= arr[0];
     
     for(int i=1; i< n; i++){
         int max= dp[i];
         for(int j=1; j<=k && i-j+1>=0 ; j++){
              max= Math.max(max, arr[i-j+1]);
             
             if(i-j>=0){
                 dp[i]= Math.max(dp[i], max*j + dp[i-j]);
             }
             else{
                 dp[i]= Math.max(dp[i], max*j);
             }
         }
     }
     
     return dp[n-1];
 }
}
