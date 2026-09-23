
//O(mxk) is the time complexity
// O(n) space complexity with dp

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

         int pivotStart = 0;
         int pivotEnd = 0;

         int maxSum = 1;
         int[] dp = new int[arr.length+1];
        
        
         for(int i = 1; i <=arr.length; i++){
            int currMax = 0;

            for(int j = 1; j <= k && i -j +1 >= 0; j++){
              
                 currMax = Math.max(currMax, arr[i-j +1 ]);x
                 dp[i] = Math.max(dp[i], (dp[i-j]+(currMax * j)));

            }       

         }
         return dp[n];
        
    }
}
