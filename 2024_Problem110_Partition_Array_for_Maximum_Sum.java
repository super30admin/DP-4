//1043. Partition Array for Maximum Sum - https://leetcode.com/problems/partition-array-for-maximum-sum/description/
//Time Complexity: O(n*k)
//Space Complexity: O(1)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i=1; i<n; i++){ //for loop for array
            int max = arr[i]; //considering incoming element as the max element
            //i-j+1>=0 to check bounds, for 1st element, there are no elements before
            for(int j=1; j<=k && i-j+1>=0; j++){ //for loop for partitions
                max = Math.max(max, arr[i-j+1]);
                if(i-j>=0){
                    dp[i] = Math.max(dp[i], max * j+dp[i-j]);
                } else{
                    //if less than 0, no element to compare with
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[n-1];
    }
}