"""
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


TIME- 0(NK)
SPACE - O(N)


"""


class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        if A == None or len(A) == 0:
            return 0
        dp = [0] * len(A)
        for i in range(len(dp)):
            max_ = 0
            for j in range(1, min(K, i + 1) + 1):  # partition
                max_ = max(max_, A[i - j + 1])
                if i >= j:  # to check we are upper bound
                    dp[i] = max(dp[i], max_ * j + dp[i - j])  # to go i-j steps back and add dp[i-j]
                else:
                    dp[i] = max(dp[i], max_ * j)

        return dp[-1]
