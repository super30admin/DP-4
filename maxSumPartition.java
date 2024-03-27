// Time Complexity : O(nk) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Approach : go exhaustive in finding all possible partitions at each index. Store the result in dp array
//to avoid recalculation of repeated sub problems. to find max, just compare with previous minimum instead of traversing over the partition again.


// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            int max = arr[i];
            int currVal = 0;
            //partitions
            for(int j = 1 ; j <= k && i - j+1>=0 ; j++){
                //incoming elements
                max = Math.max(max, arr[i-j+1]);

                currVal = j*max;
                if(i - j >= 0){
                    currVal = j*max + dp[i-j];
                }
                
                dp[i] = Math.max(dp[i],currVal); 
            }
        }

        return dp[n-1];
    }
}