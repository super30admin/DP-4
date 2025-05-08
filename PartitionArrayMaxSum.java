// Time Complexity : O(n * k), n-array length, k- max partition length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Usinga dp array to store the max sum for the first i elements.
// For each element in given array, try all partition sizes from 1 to k and update max sum using current partition's max value.
// For each partition, add partition size multiplied by max element to the previous dp value and store the maximum.

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int currMax=0;
            for(int j=1;j<=k && i-j>=0;j++){
                currMax=Math.max(currMax,arr[i-j]);
                dp[i]=Math.max(dp[i],dp[i-j]+currMax*j);
            }
        }
        return dp[n];
    }
}