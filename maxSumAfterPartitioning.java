// Time Complexity : O(Kn) n is array length
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A==null || A.length==0) return 0;
        int[] dp = new int[A.length];
        dp[0] = A[0];
        int result;
        for(int i=0;i<A.length;i++){
            dp[i] = A[i];
            int max = A[i];
            for(int j=1;i-j+1>=0 && j<=K;j++){
                max = Math.max(max,A[i-j+1]);
                if(i>=j){
                    dp[i] = Math.max(dp[i] , (j*max)+dp[i-j]);
                }
                else{
                    dp[i] = Math.max(dp[i] , (j*max));
                }
            }
            
            
        }
        return dp[dp.length-1];
        
        
    }
}