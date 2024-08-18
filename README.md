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
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n+1];

        for (int i = 1; i <= m; i++) {
            int diagup =0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                // Only proceed if the cell contains '1'

                if (matrix[i-1][j-1] == '1') {
                    
                    int curr = Math.min(dp[j], Math.min(dp[j-1],diagup)) + 1;
                    dp[j] = curr;
                    max = Math.max(max, curr);
                    
                } else{
                    dp[j]=0;
                }
                diagup= temp;
            }
        }

        // Return the area of the largest square
        return max * max;
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
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++) {
            int max = arr[i];
            for(int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + j * max);
                } else {
                    dp[i] = Math.max(dp[i], j * max);
                }
            }
        }
        return dp[n - 1];
    }
}
