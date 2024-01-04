//  Time Complexity: O(kn)
//  Space Complexity: O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null) return 0;
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];

        for(int i=1; i<n; i++){
            int max = arr[i];
            int partition_max = Integer.MIN_VALUE;

            for(int j =1; j<=k && i-j+1>=0; j++){
                max = Math.max(max, arr[i-j + 1]);

                if(i-j >= 0){
                    dp[i] =  Math.max(dp[i], j*max + dp[i-j]);
                }else{
                     dp[i] =  Math.max(dp[i], j*max );
                }
            }
        }
        return dp[n-1];
    }
}