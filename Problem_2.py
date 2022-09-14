"""
 Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.

Example 1:

Input: A = [1,15,7,9,2,5,10], K = 3

Output: 84

    Explanation: A becomes [15,15,15,9,10,10,10]

Note:

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6

"""

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        """
        Time Complexity : O(nk) n = no of elements and k no of partition
        space complexity : O(n)
        """
        if len(arr) == 0 or arr== None: return 0
        
        dp = [0 for i in range(len(arr))]
        dp[0] = arr[0]
        
        max_val = -1
        
        for i in range(1,len(arr)):
            max_val = arr[i]
            for j in range(1, k+1):
                if i - j +1 >=0:
                    max_val = max(max_val, arr[i - j + 1])
                    if i - j >= 0:
                        curr = max_val * j + dp[i - j]
                    else:
                        curr = max_val * j 
                        
                    dp[i] = max(dp[i], curr)
                    
                
        return dp[len(dp) - 1]
                
        
        