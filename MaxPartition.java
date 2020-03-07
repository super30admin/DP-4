// Time Complexity : O(KN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0){
            return 0;
        }
        int[] dp = new int[A.length];
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 1; j <= K && i - j + 1 >= 0; j++){
                max = Math.max(max,A[i-j+1]);
                if(i-j >= 0){
                    dp[i] = Math.max(dp[i], max * j + dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[A.length - 1];
    }
}