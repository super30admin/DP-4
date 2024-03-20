class Solution:
    def maximalSquare(self, matrix):
        if matrix == None or len(matrix) == 0:
            return 0
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0]*(cols+1) for _ in range(rows+1)]
        max_sqr = 0

        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == '1':
                    dp[r+1][c+1] = 1 + min(dp[r][c], dp[r+1][c], dp[r][c+1])
                    max_sqr = max(max_sqr, dp[r+1][c+1])
        return max_sqr*max_sqr
    
s = Solution()
print(s.maximalSquare([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]))
print(s.maximalSquare([["0","1"],["1","0"]]))