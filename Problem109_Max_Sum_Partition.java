// Time Complexity - O(n*K)  n = length of array K = atmost k element in subarray
// Space Complexity - O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {

        int[] dp = new int[A.length];

        for(int i=0; i<A.length;i++){
            int currMax = 0;
            for(int k=1; i-k+1 >=0 && k <= K; k++){

                // i (current) upto i-k => find currMax
                currMax = Math.max(currMax,A[i-k+1]);

                if(i >= k){

                    dp[i] = Math.max(dp[i],currMax*k + dp[i-k]);
                } else{
                    dp[i] = Math.max(dp[i],currMax*k);
                }
            }
        }
        return dp[A.length-1];
    }
}