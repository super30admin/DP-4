# Time Complexity: O(mn)
# Space Complexity: O(mn)
# Ran on Leetcode: Yes

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        dp = [[0 for _ in range(col+1)]for _ in range(row+1)]
        maximum = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == "1":
                    dp[i+1][j+1] = min(dp[i+1][j],dp[i][j],dp[i][j+1])+1
                    maximum = max(maximum,dp[i+1][j+1])
                
        return maximum*maximum