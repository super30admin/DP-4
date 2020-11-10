"""
Time Complexity: O(NK)
Space Complexity: O(N)
"""


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], K: int) -> int:

        dp = [float('-inf') for i in range(len(arr) + 1)]
        dp[-1] = 0
        dp[-2] = arr[-1]

        for j in reversed(range(len(arr) - 1)):
            cur_max = float('-inf')
            for k in range(K):
                if j + k == len(arr):
                    break
                cur_max = max(cur_max, arr[j + k])
                dp[j] = max(dp[j], (k + 1) * cur_max + dp[j + k + 1])

        return dp[0]
