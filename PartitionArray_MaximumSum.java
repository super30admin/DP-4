// Time Complexity :O(n*k)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
      int n = arr.length;
      int[] dp = new int[n];  
        
      dp[0] = arr[0];
        
      for(int i =1; i< n ; i++){
            int max = arr[i];
          for(int j=1 ; j <=k && i-j+ 1 >= 0; j++){
              //current element comare with incoming element -> i is length, j is size of partition
              max= Math.max(max,arr[i-j+1]);
             //  curr = patition value(max * length of current paritition) + value of remaining sub problems
              int curr = 0;
              if(i-j >=0){
                 curr = max*j  + dp[i-j];
              } else{
               curr = max*j ;
              }  
               
            dp[i] = Math.max(dp[i], curr);   
 
              }
              
          }
        return dp[n-1];
          
      }
        
        
    }

