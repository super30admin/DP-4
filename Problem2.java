/*
    LC - 1043. Partition Array for Maximum Sum
    TC - O(nk)
    SC - O(n)
    Approach -
        Traverse through the array
        Traverse for K elements and find the max for the K elements
        check the boundary i - j >=0 and calculate max accordingly and store in dp
        return dp[n-1]
*/

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1; i<n; i++) {
            int max = arr[i];
            for(int j=1; j<=k && i-j+1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i-j] + j* max);
                } else {
                    dp[i] = Math.max(dp[i], j* max);
                }
            }
        }
        return dp[n - 1];
    }
}