// Time Complexity : O(nk)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len];
        
        int max = A[0];
        for(int i = 0; i < K; i++){
            max = Math.max(max, A[i]);
            dp[i] = max * (i+1);
        }
        
        for(int i = K;i < len; i++){
            max = A[i];
            for(int j = 1; j <= K; j++){
                max = Math.max(max, A[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }
        
        return dp[len - 1];
    }
}
