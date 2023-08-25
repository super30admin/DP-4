// Time Complexity :O(nk)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        //dp array
        int[] dp = new int[len];
        //First element will be the same as original array
        dp[0] = arr[0];

        //For every element, try k number of partitions
        for(int i=1; i<len; i++){
            int currmax = 0;
            
            for(int j=1; j<=k && i-j+1 >=0; j++){
                currmax = Math.max(currmax, arr[i-j+1]);
                if(i-j<0) dp[i] = Math.max(dp[i],j*currmax);
                else dp[i] = Math.max(dp[i], j*currmax + dp[i-j]);
            }
        }
        return dp[len-1];
    }
}