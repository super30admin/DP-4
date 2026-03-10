# Time Complexity : O(m * n), m = number of rows, n = number of columns
# Space Complexity : O(m * n) for the DP table
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use dynamic programming to track the side length of the largest square ending at (i, j).
# 2. If matrix[i][j] == '1', dp[i][j] = 1 + min(top, left, top-left) neighbors.
# 3. Keep track of the maximal side length and return its area.

from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        max_side = 0
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                    max_side = max(max_side, dp[i][j])
        
        return max_side * max_side