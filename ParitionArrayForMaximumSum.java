// Time: O(NK) | Space: O(K)

//DP soln
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            int max = arr[i];
            // comparing all the paritions till k size
            for(int j=1;j<=k && i-j+1 >= 0;j++) {
                max = Math.max(max, arr[i-j+1]);
                if(i-j >= 0)
                    dp[i] = Math.max(dp[i], max*j+dp[i-j]);
                else
                    dp[i] = Math.max(dp[i], max*j);
            }
        }
        return dp[n-1];
    }
}