# The maxSumAfterPartitioning method finds the maximum sum after partitioning an array into subarrays of size at most k.

# Use recursion with memoization:
# - `dfs(i)` computes the maximum sum starting from index `i`.
# - For each partition starting at `i`, track the maximum element (`curMax`) and calculate the partition sum.
# - Update `curSum` with the maximum sum from valid partitions and recursively call `dfs` for the next index.

# Memoize results for efficiency and return the maximum sum from index 0.

# TC: O(n * k) - Each index is processed with up to k subarray evaluations.
# SC: O(n) - Space for memoization and recursion stack.


from typing import List


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        memo = {}

        def dfs(i):
            if i == n:
                return 0
            if i in memo:
                return memo[i]
            curMax = curSum = 0
            for j in range(i, min(i + k, n)):
                curMax = max(curMax, arr[j])
                cur = curMax * (j - i + 1) + dfs(j + 1)
                curSum = max(curSum, cur)
            memo[i] = curSum
            return curSum

        return dfs(0)
