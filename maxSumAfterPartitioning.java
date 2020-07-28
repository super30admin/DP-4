//Time : O(mk) m and k are the length and window size of the array
//Space: O(n)
//Leetcode : worked

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int[] dp = new int[n];
        for(int i =0 ;i<n;i++){
            int max = A[i];
            for(int j =1;i-j+1>=0 && j<=K;j++){
                max = Math.max(max,A[i-j+1]);
                if(i>=j){
                    dp[i] = Math.max(dp[i],dp[i-j] + max*j);
                }else{
                    dp[i] = Math.max(dp[i],max*j);
                }
            }
        }
        
        return dp[n-1];
    }
}