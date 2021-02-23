# TC: O(mn)
# SC: O(mn)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0 for j in range(n+1)] for i in range (m+1)]
        max_val = 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                    max_val = max(max_val, dp[i][j])
            
        return max_val*max_val