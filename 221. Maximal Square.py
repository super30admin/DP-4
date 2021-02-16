# T = O(mn)
# S = O(mn)

# Approach:
# Build a DP matrix and find the max element.Can optimise it to 1D array

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0] * (n+1) for j in range(m+1)]
        maxx = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i-1][j],
                                      dp[i][j-1],
                                      dp[i-1][j-1]
                                      )
                    maxx = max(maxx,dp[i][j])
        return maxx ** 2