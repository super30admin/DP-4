// TC - O(nk) || SC - O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int[] dp = new int[A.length];
        int max = 0;
        for(int i=0;i<dp.length;i++) {
            int j = 1;
            max = 0;
            while(i-j+1 >= 0 && j <= K) {
                max = Math.max(A[i-j+1],max);
                if(i >= j) {
                    dp[i] = Math.max(dp[i],dp[i-j]+max*j);
                } else {
                    dp[i] = Math.max(dp[i],max*j);
                }
                j++;
            }
        }
        return dp[dp.length-1];
    }
}