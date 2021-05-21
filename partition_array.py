# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not len(arr):
            return 0
        n = len(arr)
        dp = [0] * n
        for i in range(n):
            m = arr[i]
            j = 1
            while j <= k and i - j + 1 >= 0:
                m = max(m, arr[i - j + 1])
                if i - j >= 0:
                    dp[i] = max(dp[i], dp[i - j] + m * j)
                else:
                    dp[i] = max(dp[i], m * j)
                j += 1
            
        return dp[n - 1]
                