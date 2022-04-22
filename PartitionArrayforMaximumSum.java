//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

public class PartitionArrayforMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int i=1;i<dp.length;i++){
            int max = Integer.MIN_VALUE;
            int best = Integer.MIN_VALUE;
            for(int j=1;j<=k && i-j>=0 ;j++){
                //System.out.println(i+" "+j);
                max= Math.max(max,arr[i-j]);
                best = Math.max(best, dp[i-j]+max * j);
            }
            dp[i] = best;
        }
        return dp[n];
    }
}
