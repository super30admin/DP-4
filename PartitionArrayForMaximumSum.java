//time - O(nk)
//space - O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;

        int max, sum;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for(int i=1; i<n; i++){
            max = nums[i];
            for(int j=1; j<=k && i-j+1>=0; j++){
                max = Math.max(max, nums[i-j+1]);
                int add = (i-j<0) ? 0 : dp[i-j];
                sum = max * j + add;
                dp[i] = Math.max(sum, dp[i]);
            }
        }

        return dp[n-1];
    }
}
