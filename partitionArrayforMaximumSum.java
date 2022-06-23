// Time Complexity : O(n*k) - n =arr.length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int max = 0;
        int[] dp = new int[arr.length+1];
        dp[0] = arr[0];
        for(int i=0;i<arr.length;i++){
            max = arr[i];
            for(int j=1;j<=k && i-j+1>=0;j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j>=0){
                    dp[i] = Math.max(dp[i], (max*j)+dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i], (max*j));
                }
            }
        }
        return dp[arr.length-1];
    }
}