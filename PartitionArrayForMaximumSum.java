// Time Complexity : O(n*k)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Initialization: Use a dynamic programming array dp to store the maximum sum for partitions ending at each index.
//Update: For each index i, look back up to k elements, calculating the maximum partition sum possible by considering all subarrays ending at i and updating dp[i] accordingly.
//Result: The value dp[n-1] will contain the maximum sum after partitioning the array, so return that.

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int dp[] = new int[n];
        dp[0]= arr[0];
        for(int i=1; i< n;i++){
            int max = arr[i];
            for(int j=1; j<=k && i-j+1>=0; j++){
                max = Math.max(max,arr[i-j+1]);
                if(i-j >=0){
                    dp[i] = Math.max(dp[i],dp[i-j]+j*max);
                }
                else{
                    dp[i] = Math.max(max, j * max);
                }
            }
        }
        return dp[n-1];
    }
}