// Partition Array for Maximum Sum

// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++){
            int max = arr[i];
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                max = Math.max(max, arr[i-j+1]);
                int currVal = max * j;
                if(i-j >= 0){
                    currVal += dp[i-j];
                }
                dp[i] = Math.max(dp[i], currVal);
            }
        }
        return dp[n-1];
    }
}