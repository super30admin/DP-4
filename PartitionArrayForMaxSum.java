class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        
        int max = A[0];
        for(int i = 0; i < K; i++){
            max = Math.max(max, A[i]);
            dp[i] = max * (i+1);
        }
        
        for(int i = K; i < n; i++){
            max = A[i];
            for(int j =1; j<=K; j++){
                max = Math.max(max,A[i-j+1]);
                dp[i] = Math.max(dp[i],dp[i-j]+ max*j);
            }
        }
        return dp[n-1];
    }
}