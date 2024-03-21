public class Partition_Array_for_Maximum_Sum {
    //TC: O(n*k)
    //SC: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++){
            int max = arr[i];
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                max = Math.max(max, arr[i-j+1]);
                int curr_Par = j*max;
                if(i-j >= 0){
                    curr_Par = j*max + dp[i-j];
                }
                dp[i] = Math.max(dp[i], curr_Par);
            }
        }
        return dp[n-1];
    }
}
