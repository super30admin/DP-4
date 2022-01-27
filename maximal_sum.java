// Time Complexity : O(n*k)
// Space Complexity : O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        // 1D DP array
        int[] dp =  new int[arr.length];
        
        // first element 
        dp[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++ ){
            
            int max = arr[i];
            
            for (int partition = 1 ; partition <= k ; partition++ ){
                
                if (i - partition < 0){
                    
                    // In this case, the value will be from all the elements (a single partition)
                    dp[i] = Math.max(dp[i] , partition * max);
                    break;
                }
                
                // compute the value of the partition from previously computed dp and add the value into 
                dp[i] = Math.max( dp[i - partition] + partition * max , dp[i]);

                max = Math.max(arr[i- partition], max);
                
            }
        }
        
        return dp[arr.length - 1];
        
    }
}