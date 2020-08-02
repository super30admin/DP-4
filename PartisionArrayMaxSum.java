//Time complexity=O(m*k)
//Space complexity=O(m) size of the dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0)return 0;
        int n = A.length;
        int[] dp = new int [n];
        for(int i = 0; i < n; i++){
            int max = A[i];
            for(int j = 1; i-j+1 >=0 && j<=K ;j++){
                max = Math.max(max,A[i-j+1]);
                if(i>=j){
                    dp[i] = Math.max(dp[i],dp[i-j]+max*j);
                }else{
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[dp.length-1];
    }
}