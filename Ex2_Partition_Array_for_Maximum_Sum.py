# ----------------------------------------------------
# Intuition:
#
# We want to partition the array into subarrays of size at most k.
# Each partition is replaced with the max element in that partition,
# and we want the sum of all such replacements to be maximized.
#
# 1. Bottom-Up DP (Tabulation):
#    - Build dp[i] = max sum for arr[0..i]
#    - At each i, try all partition sizes j (1 <= j <= k)
#    - Update dp[i] = max(dp[i], dp[i - j] + max_in_partition * j)
#    → Time: O(n * k), Space: O(n)
#
# 2. Top-Down Memoization:
#    - For each index i, try all j from 1 to k and recurse
#    - Memoize results for index i
#    → Time: O(n * k), Space: O(n)
#
# 3. Brute Force Recursion:
#    - Same as memoization but no caching
#    - Recomputes overlapping subproblems
#    → Time: Exponential, Space: O(n) call stack
# ----------------------------------------------------

from typing import List

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * (n + 1)  # dp[i] = max sum for first i elements

        for i in range(1, n + 1):
            max_val = 0
            # Try partition sizes 1 to k (as long as valid)
            for j in range(1, min(k, i) + 1):
                max_val = max(max_val, arr[i - j])
                dp[i] = max(dp[i], dp[i - j] + max_val * j)

        return dp[n]

    # ----------------------------------------------------
    # 💬 Memoization (Top-Down DP)
    # ----------------------------------------------------
    # def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
    #     n = len(arr)
    #     memo = {}

    #     def dfs(i):
    #         if i == n:
    #             return 0
    #         if i in memo:
    #             return memo[i]

    #         max_val = 0
    #         res = 0
    #         for j in range(i, min(i + k, n)):
    #             max_val = max(max_val, arr[j])
    #             res = max(res, (j - i + 1) * max_val + dfs(j + 1))

    #         memo[i] = res
    #         return res

    #     return dfs(0)

    # ----------------------------------------------------
    # 💬 Brute Force Recursion (No Memoization)
    # ----------------------------------------------------
    # def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
    #     def dfs(i):
    #         if i == len(arr):
    #             return 0

    #         max_val = 0
    #         res = 0
    #         for j in range(i, min(i + k, len(arr))):
    #             max_val = max(max_val, arr[j])
    #             res = max(res, (j - i + 1) * max_val + dfs(j + 1))

    #         return res

    #     return dfs(0)


if __name__ == "__main__":
    sol = Solution()

    # Test case 1
    arr1 = [1, 15, 7, 9, 2, 5, 10]
    k1 = 3
    print("Test 1 Output:", sol.maxSumAfterPartitioning(arr1, k1))  # Expected: 84

    # Test case 2
    arr2 = [1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3]
    k2 = 4
    print("Test 2 Output:", sol.maxSumAfterPartitioning(arr2, k2))  # Expected: 83

    # Test case 3
    arr3 = [1]
    k3 = 1
    print("Test 3 Output:", sol.maxSumAfterPartitioning(arr3, k3))  # Expected: 1

    # Test case 4 (Edge Case - All Same Values)
    arr4 = [5, 5, 5, 5, 5]
    k4 = 2
    print("Test 4 Output:", sol.maxSumAfterPartitioning(arr4, k4))  # Expected: 25

    # Test case 5 (Large k)
    arr5 = [2, 1, 4, 3, 6]
    k5 = 5
    print("Test 5 Output:", sol.maxSumAfterPartitioning(arr5, k5))  # Expected: 30
