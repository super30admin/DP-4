#Time Complexity: O(m*n)
#Space Complexity: O(n)

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        """m = len(matrix)
        n = len(matrix[0])

        max = 0
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if matrix[i][j] == '1':
                    dp[i][j] = 1 + min(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1])
                    max = max if max > dp[i][j] else dp[i][j]

        return max * max"""
        m, n, max = len(matrix), len(matrix[0]), 0

        dp = [0] * (n + 1)
        diagUp = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                temp = dp[j]
                if matrix[i - 1][j - 1] == '1':
                    dp[j] = 1 + min(dp[j], dp[j - 1], diagUp)
                    max = max if max > dp[j] else dp[j]
                else: dp[j] = 0
                diagUp = temp

        return max * max
        