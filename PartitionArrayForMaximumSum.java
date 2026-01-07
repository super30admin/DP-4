
class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // whats max value if current element is choosen , or if one after other left elements are
        // considered untill i get 'k' elements in my partition
        // using dp approach
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++) { 
            int currMax = 0;

            for(int j = 1; j <= k && i - j + 1 >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j + 1]);

                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], currMax * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], currMax * j);
                }
            }
        }
        return dp[arr.length-1];
    }
}