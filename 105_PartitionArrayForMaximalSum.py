'''
Accepted on leetcode(1043)
Time - O(N^2)
Space - O(N)
Done using the dynamic programming approach by reusing the saved data.
'''


class Solution:
    def maxSumAfterPartitioning(self, A, K: int) -> int:
        n = len(A)
        dp = [0 for i in range(n)]
        for i in range(n):
            maximum = 0
            for j in range(1, K + 1):
                if i - j + 1 >= 0:
                    maximum = max(maximum, A[i - j + 1])
                    dp[i] = max(dp[i], ((dp[i - j] if i >= j else 0) + maximum * j))

        return dp[n - 1]
