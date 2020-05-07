// Time Complexity - O(n*K) where n is the length of A
// Space Complexity - O(n) 
// This Solution worked on Leetcode

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length ==0)   return 0;
        int n = A.length;
        int[] dp = new int[n];
        for(int i=0;i< n;i++){
            int max =0;
            for(int j = 1;j <= K && i-j+1 >=0;j++){
                max = Math.max(max,A[i-j+1]);
                dp[i] = Math.max(dp[i], (i >= j?dp[i-j]:0)+max*j);
            }
        }
        return dp[n-1];
    }
}
