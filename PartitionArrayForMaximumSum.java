//Leetcode - 1043
//TimeComplexity - O(NK)
//SpaceComplexity - O(N)
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            int max = arr[i];
            for(int j=1; j<=k && i-j+1 >=0 ;j++) {
                max = Math.max(max, arr[i-j+1]);
                if(i-j >=0) {
                    dp[i] = Math.max(dp[i], (j*max+dp[i-j]));
                } else {
                    dp[i] = Math.max(dp[i], j*max);
                }
            }
        }
        return dp[n-1];
    }
}
