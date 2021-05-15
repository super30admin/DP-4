// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        int max = arr[0];
        for(int i = 0 ; i < k ; i++){
            max = Math.max(arr[i],max);
            dp[i] = max * (i+1);
        }
            
        
        for(int i = k ; i < arr.length ; i++){
            max = arr[i];
            for(int j = 1 ; j <= k ; j++){
                max = Math.max(max,arr[i-j+1]);
                dp[i] = Math.max( dp[i] , dp[i-j]+ (max*j) );
            }
        }

        return dp[arr.length-1];
    }
}
