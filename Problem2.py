#time complexity o(m * n)
#space complexity o(m*n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        Dmax = 0
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if matrix[i][j] == '1':
                    dp[i][j] = 1+ min(dp[i+1][j],dp[i][j+1],dp[i+1][j+1])
                    Dmax = max(Dmax,dp[i][j])

        return Dmax * Dmax