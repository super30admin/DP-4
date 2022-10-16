/*
## Problem 2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

Time Complexity :   O (K*n) 
Space Complexity :  O (n)
Did this code successfully run on Leetcode :    Yes (1043. Partition Array for Maximum Sum)
Any problem you faced while coding this :       No
 */
// Input: arr = [1,15,7,9,2,5,10], k = 3
// Output: 84

class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        
        for(int i=1; i< n; i++){
            max = arr[i];
            for(int j=1; j<=k && i-j+1 >=0; j++){
                max = Math.max(max, arr[i-j+1]);
                
                int curr = 0;
                if(i-j >=0){
                    curr = j*max + dp[i-j];
                }
                else{
                    curr = j*max;
                }
                dp[i] = Math.max(curr, dp[i]);
            }
        }
        return dp[n-1];
    }
}