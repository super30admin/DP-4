// TC: O(kn)
// SC: O(n)

// 1: We maintain a DP array to calculate the maximum sum obtained thus far from each possible partition up to that element
// 2: For each element, we check all partition sizes up to size k
// 3: The maximum partition sum obtained between each maxElement and the length of the partition is stored in the DP array

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for(int i = 0 ; i<n; i++){
            int maxEle = arr[i];
            for(int l = 1; l<=k && i-l+1 >= 0; l++){
                maxEle = Math.max(maxEle, arr[i-l+1]);
                int currPartitionSum = maxEle * l;
                if(i -l >= 0){
                    currPartitionSum += dp[i-l];
                }
                dp[i] = Math.max(dp[i], currPartitionSum);
            }
        }
        return dp[n-1];
    }
}