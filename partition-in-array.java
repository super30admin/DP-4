class Solution {
    // DP solution
    // Time complexity is O(n)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Edge case
        if(arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int dp [] = new int [n];
        dp[0] = arr[0];
        for(int i = 0 ; i<n; i++){
            int max = arr[i];
            for(int j = 1; j<=k && i-j+1 >=0; j++){
                max = Math.max(max,arr[i-j+1]);
                if(i-j >=0){
                    int cal = max*j + dp[i-j];
                    dp[i] = Math.max(cal, dp[i]);
                } else{
                    int cal = max*j;
                    dp[i] = Math.max(cal, dp[i]);
                }
            }
        }
        return dp[n-1];
    }
}