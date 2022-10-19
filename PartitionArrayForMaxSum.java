// Time Complexity : O(kn)
// Space Complexity :O(n)
// n is the length of given array and k is the max partition length
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            int max = arr[i];
            for(int j = 1 ; j <= k && i-j+1 >= 0 ; j++){
                max = Math.max(max,arr[i-j+1]);
                int curr = 0;
                if(i-j >= 0){
                    curr = j*max + dp[i-j];
                }
                else{
                    curr = j*max;
                }
                dp[i] = Math.max(dp[i],curr);
            }
        }
        return dp[n-1];
    }
}