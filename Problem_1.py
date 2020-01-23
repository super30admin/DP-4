# Runs on Leetcode
    # Runtime - O(m*n)
    # space - O(m*n) where m is # of rows and n is # of cols

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        rows = len(matrix)
        cols = len(matrix[0])
        
        result = 0
        dp = [[0 for j in range(cols+1)] for i in range(rows+1)]
        
        for j in range(cols+1):
            dp[0][j] = 0
        for i in range(rows+1):
            dp[i][0] = 0
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    dp[i+1][j+1] = min(min(dp[i][j], dp[i][j+1]),dp[i+1][j])+1
                    result = max(result, dp[i+1][j+1])
        return result*result
