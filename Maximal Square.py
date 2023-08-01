# Time Complexity : O(m*n)
# Space Complexity : O(m*n) to maintain the dp matrix

# The code ran on Leetcode

# Maintain a separate dp matrix. Iterate over the input matrix and update value in the dp matrix only when value in the original matrix is 1. Find the smallest square that can be formed to the top, left and upper diagonal to the current position

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix); n = len(matrix[0])
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        res = 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                res = max(res, dp[i][j])
        return res*res