//The idea here is to use Bottom-up DP to store the maximum among all the partitions in a dp array as we iterate through the array. 
//At each index, we find the maximum possible result that we get from the partitions up to the index.
//Time complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i<n; i++){
            int max = 0;
            for(int j = 1; j <=k && i-j+1 >= 0; j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j < 0){
                    dp[i] = Math.max(dp[i], max*j + 0);
                } else {
                    dp[i] = Math.max(dp[i], max*j + dp[i-j]);
                }                
            }
        }
        return dp[n-1];
    }
}