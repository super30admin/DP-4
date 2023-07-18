# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        m, n = len(matrix), len(matrix[0])

        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        maxVal = 0

        for r in range(1, m+1):
            for c in range(1, n+1):
                if matrix[r-1][c-1] == "1":
                    dp[r][c] = 1 + min(dp[r-1][c-1], dp[r][c-1], dp[r-1][c])
                    maxVal = max(maxVal, dp[r][c])
    
        return maxVal*maxVal