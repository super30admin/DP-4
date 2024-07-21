//Time - O(n*k), space - O(n)
class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for(int i=1; i<n; i++) {
            int max = nums[i];
            for(int j=1; j <= k && i-j+1 >= 0; j++) {
                max = Math.max(max, nums[i - j + 1]);
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }

        return dp[n-1];
    }
}
