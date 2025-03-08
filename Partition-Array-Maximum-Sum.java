## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.

Example 1:

Input: A = [1,15,7,9,2,5,10], K = 3

Output: 84

    Explanation: A becomes [15,15,15,9,10,10,10]

Note:

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6

Time Complexity : O(nk)
Space Complexity : O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr==null || arr.length==0 ||k==0){
            return 0;
        }
        int n=arr.length;
        int[] dp = new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int max=arr[i];
            for(int j=1;j<=k && i-j+1>=0;j++){
                 max=Math.max(max,arr[i-j+1]);
                 if(i-j>=0){
                    dp[i]=Math.max(dp[i],dp[i-j]+j*max);
                 }
                 else{
                    dp[i] = Math.max(dp[i],j*max);
                 }
            }
        }
        return dp[n-1];
    }
}