# DP approach, we can use a 2D array to store the length of the largest square
# ending at each position. The value of dp[i][j] is the length of the largest
# square ending at position (i, j). If matrix[i][j] is "1", then dp[i][j] is
# equal to the minimum of dp[i-1][j], dp[i][j-1], and dp[i-1][j-1] plus 1.
# Time complexity: O(m * n)
# Space complexity: O(m * n)


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0
        maxi = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    maxi = max(maxi, dp[i][j])
        return maxi * maxi


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0
        maxi = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [0] * (n + 1)
        for i in range(m):
            temp = dp[0]
            for j in range(1, n + 1):
                prev = dp[j]
                if matrix[i][j - 1] == "1":
                    dp[j] = min(dp[j - 1], dp[j], temp) + 1
                    maxi = max(maxi, dp[j])
                else:
                    dp[j] = 0
                temp = prev
        return maxi * maxi