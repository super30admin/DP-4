"""
TC: O(m*n)
SC: O(m+1*n+1) ~O(m*n)
"""
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        ROWS = len(matrix)
        COLS = len(matrix[0])
        dp = [[0 for _ in range(COLS+1)]for _ in range(ROWS+1)]
        res = 0
        for r in range(ROWS-1, -1, -1):
            for c in range(COLS-1, -1, -1):
                if matrix[r][c]=='1':
                    dp[r][c] = min(dp[r][c+1], dp[r+1][c], dp[r+1][c+1])+1
                    res = max(res, dp[r][c])
        return res*res