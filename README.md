# DP-4
## Problem1:(https://leetcode.com/problems/maximal-square/)

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 


1 0 1 0 0

1 0 1 1 1

1 1 1 1 1

1 0 0 1 0

Output: 4


class Solution {
    
    //TC O(m*n) SC O(n)
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int prev =0, temp =0;
        int max = 0;
        int[] dp = new int[n+1];
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                prev = dp[j+1];
                if(matrix[i][j] == '1'){
                dp[j+1] = 1 + Math.min(dp[j], Math.min(dp[j+1], temp));
            }
            else{
                dp[j+1] = 0;
                
            }
            
            max = Math.max(max, dp[j+1]);
            temp = prev;
        }
        
    }
        return max*max;
}

}


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


class Solution {
    //TC O(n*k) SC O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if( arr == null || arr.length ==0) return 0;
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        
        for(int i =1; i< arr.length; i++){
            int max = arr[i];
            for(int j =1; j<=k && i-j+1>=0; j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j>=0){
                dp[i] = Math.max(dp[i], max*j + dp[i-j]); 
            }else{
                dp[i] = Math.max(dp[i], max*j); 
                }
        }
    }
        return dp[arr.length-1];
}
}
