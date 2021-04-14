class PartitionArrayForMaximumSum {
    
    // Time Complexity: O(nk)   (where n -> no. of elements in the array)
    // Space Complexity: O(n)
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0)
            return 0;
        
        int n = arr.length;
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++){
            int maxVal = Integer.MIN_VALUE;
            for(int j = 1; j <= k && (i-j+1) >= 0; j++){
                maxVal = Math.max(maxVal, arr[i-j+1]);
                if(i >= j){
                    dp[i] = Math.max(dp[i], maxVal * j + dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i], maxVal * j);
                }
            }
        }
        
        return dp[n-1];
    }
}