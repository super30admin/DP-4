/* Time Complexity : O(n*k)) 
 *  k - max len of partition 
 *  n - len of arr */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//DP

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++){
            int max = arr[i];
            //i - j + 1 -> to include 3 ele in a partition
            for(int j = 1; j <= k && i - j + 1 >= 0; j++){
                max = Math.max(max, arr[i - j + 1]);
                int curr = 0;
                if(i - j >= 0){
                    curr = max * j + dp[i-j];
                }
                else{
                    curr = max * j;
                }
                dp[i] = Math.max(dp[i], curr);
            }
        }
        return dp[n-1];
    }
}