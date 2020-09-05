//TC: O(n*k)
//SC: O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        if(n==0) return 0;
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++){
            int max = arr[i];
            for(int j = 1; i-j+1 >= 0 &&  j<= k; j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j >= 0) dp[i] = Math.max(dp[i], dp[i-j] + j*max);
                else dp[i] =  Math.max(dp[i], j*max);
            }
        }
        return dp[n-1];
    }
}
