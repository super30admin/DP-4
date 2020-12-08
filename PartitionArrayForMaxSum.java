package Dec8;

class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        /*
        Time complexity: O(nk) where n is length of array.
        
        Approach: DP array.
        */
        
        // edge
        if (arr == null || arr.length == 0) {
            return 0;
        }
  
        int n = arr.length;
        int[] dp = new int[n];
         
        for (int i = 0; i < n; i++) {
            // reset max pointer to current array element for the case when single partition using only current array element is considered.
            int max = arr[i];
            for (int j = 1; i-j+1 >= 0 && j <= k ;  j++) {
                max = Math.max(max, arr[i-j+1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i-j] + max*j); 
                } else {
                    dp[i] = Math.max(dp[i], max*j); 
                }
            }
        }
        return dp[n-1];
    }
}