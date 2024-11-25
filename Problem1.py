class Solution:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        max_dim = 0
        dp = [[0] * m for _ in range(n)]

        for i in range(n):
            for j in range(m):
                if matrix[i][j] == '1':
                    left = up = diag = 0
                    if i > 0:
                        up = dp[i - 1][j]
                    if j > 0:
                        left = dp[i][j - 1]
                    if i > 0 and j > 0:
                        diag = dp[i - 1][j - 1]
                    dp[i][j] = min(left, up, diag) + 1
                    max_dim = max(max_dim, dp[i][j])

        return max_dim * max_dim