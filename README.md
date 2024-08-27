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



Explain the algorithm in 3 lines: In this approach we will use a dynamic programming array dp to store the side length of the largest square ending at each position in the matrix. For each cell in the matrix, if the cell will contains 1 then we will update dp[j] to the minimum of its neighbour plus one where it is representing the side length of the square. At the end once we find out the maximum side length we will return its area as max*max.

Time Complexity: O(m*n) where m is number of rows and n is number of columns in the matrix as each cell of the matrix will be processed once

Space Complexity: O(n) as we are creating DP array that uses space propotional to the number of columns in the matrix

Approached Code:

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         if(matrix[i][j] == '1') {
        //             int l = 1;
        //             boolean flag = true;

        //             while(flag && i+l < m && j+l < n) {
        //                 for(int k = i+l; k >= i; k--) {
        //                     if(matrix[k][j+l] == '0') {
        //                         flag = false;
        //                         break;
        //                     }
        //                 }

        //                 for(int k = j+l; k >= j; k--) {
        //                     if(matrix[i+l][k] == '0') {
        //                         flag = false;
        //                         break;
        //                     }
        //                 }

        //                 if(flag) {
        //                     l++;
        //                 }
        //             }

        //             max = Math.max(max, l);
        //         }
        //     }
        // }

        // int[][] dp = new int[m+1][n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= m; i++) {
            int diagUp = 0;
            for(int j = 1; j <= n; j++) {
                int temp = dp[j];

                if(matrix[i-1][j-1] == '1') {
                    // int curr = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    // dp[i][j] = curr;
                    int curr = 1 + Math.min(dp[j], Math.min(dp[j-1], diagUp));
                    dp[j] = curr;
                    max = Math.max(max, curr);
                } else {
                    dp[j] = 0;
                }

                diagUp = temp;
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



Explain the algorithm in 3 lines: We will use dynamic programming to calculate the maximum sum for each subarray ending at index i considering all possible partitions up to k elements. For each index i we will find the maximum element in the last k elements and compute the sum if those elements formed a partition updating the DP array accordingly. At the end we will return the maximum sum for the entire array sorted in dp[n-1];

Time Complexity: O(n*k) where n is the length of the array and k is the maximum partition size as we will calculate the sum for each possible partition at each index.

Space Complexity: O(n) where n is length of array for the DP array storing the maximum sums for subarrays ending at each index

Approached Code:

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n];

        dp[0] = arr[0];

        for(int i = 1; i < n; i++) {
            int currPartMax = arr[i];

            for(int j = 1; j <= k && i - j + 1 >= 0; j++) {
                currPartMax = Math.max(currPartMax, arr[i-j+1]);

                int currSum = currPartMax * j;

                if(i - j >= 0) {
                    currSum = currSum + dp[i - j];
                }

                dp[i] = Math.max(dp[i], currSum);

            }

            
        }

        return dp[n-1];
    }
}




