## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

# Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

# Return the largest sum of the given array after partitioning.

# Example 1:

# Input: A = [1,15,7,9,2,5,10], K = 3

# Output: 84

#     Explanation: A becomes [15,15,15,9,10,10,10]

# Note:

# 1 <= K <= A.length <= 500
# 0 <= A[i] <= 10^6

class Solution:
    def maxSumAfterPartitioning(self, arr: list[int], k: int) -> int:
        """
        SOLUTION 1: Bottom-Up Dynamic Programming (Tabulation)
        
        LOGIC:
        - We build the solution iteratively from the back of the array (n - 1) down to index 0.
        - dp[index] represents the maximum sum obtainable from the subarray starting at `index` 
          all the way to the end of `arr`.
        - Base case: dp[n] = 0 (an empty subarray contributes 0 sum).
        - For each `index`, we test partition lengths `j` from 1 to `k`.
        - While expanding `j`, we keep track of the maximum element seen in the partition 
          (`maxInPartition`).
        - The score for choosing a partition of length `j` starting at `index` is:
            (maxInPartition * j) + dp[index + j]
        - We store the maximum result among all valid `j` into `dp[index]`.
        - The final answer is stored in `dp[0]`.

        TIME COMPLEXITY: O(N * k)
        - Outer loop runs N times (for each index from n - 1 down to 0).
        - Inner loop runs up to k times to evaluate partitions of lengths 1..k.
        - Overall operations: ~N * k, which easily passes within time limits.

        SPACE COMPLEXITY: O(N)
        - Uses a 1D DP array of size (N + 1) to store subproblem results.
        - Does not use additional call stack space since it is purely iterative.
        """
        n = len(arr)
        dp = [0] * (n + 1)

        # Work backwards from the last element to index 0
        for index in range(n - 1, -1, -1):
            maxInPartition = 0
            maxSum = 0

            # Try forming a partition of length 1 to k starting at `index`
            for j in range(1, k + 1):
                if index + j <= n:
                    # Maintain running maximum of current partition range arr[index : index + j]
                    maxInPartition = max(maxInPartition, arr[index + j - 1])
                    
                    # Score = current partition value + precomputed answer for remaining subarray
                    currSum = (maxInPartition * j) + dp[index + j]
                    maxSum = max(maxSum, currSum)
                else:
                    break

            dp[index] = maxSum

        return dp[0]


        """
        SOLUTION 2: Top-Down Dynamic Programming (Recursion with Memoization)
        
        LOGIC:
        - Uses a recursive helper function `solve(index)` to evaluate the maximum sum for 
          `arr[index:]`.
        - Base Case: When `index == len(arr)`, return 0.
        - Memoization: Before computing, we check `memo[index]`. If already computed 
          (!= -1), we return the cached value immediately to avoid duplicate computations.
        - For a given `index`, we try all valid partition lengths `j` from 1 to `k`.
        - For each `j`, we track `maxInPartition` and recursively solve for the remainder 
          `solve(index + j)`.
        - We store the best partition sum into `memo[index]` before returning it.

        TIME COMPLEXITY: O(N * k)
        - There are N unique subproblems (`solve(0)` through `solve(N-1)`).
        - Each state executes a loop running up to k times.
        - Thanks to memoization, each state is computed exactly once.

        SPACE COMPLEXITY: O(N)
        - `memo` table takes O(N) auxiliary space.
        - The recursive call stack can go up to depth N in the worst case (when partitions are length 1).
        - Total Space = O(N) for memo table + O(N) stack space = O(N).
        """
        # memo = [-1] * (len(arr) + 1)

        # def solve(index: int) -> int:
        #     nonlocal k, arr

        #     # Base case: empty remaining array
        #     if index == len(arr):
        #         return 0

        #     # Memoization lookup
        #     if memo[index] != -1:
        #         return memo[index]

        #     maxInPartition = 0
        #     maxSum = 0

        #     # Explore all partition options of size 1..k
        #     for j in range(1, k + 1):
        #         if index + j <= len(arr):
        #             maxInPartition = max(maxInPartition, arr[index + j - 1])
        #             currSum = (maxInPartition * j) + solve(index + j)
        #             maxSum = max(maxSum, currSum)
        #         else:
        #             break

        #     # Cache the result before returning
        #     memo[index] = maxSum
        #     return memo[index]

        # return solve(0)