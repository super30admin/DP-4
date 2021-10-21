package DP4;

//Time complexity : O(n*k) as we are calculating min for each element
//Space complexity: O(n)
public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length+1];
        for(int i=1;i<dp.length;i++){
            int max = 0;
            for(int j=i; j> Math.max(0, i-k); j--){
                max = Math.max(arr[j-1], max);
                dp[i] = Math.max(dp[i], max*(i-j+1) + dp[j-1]);
            }
        }
        return dp[dp.length-1];
    }
}
