"""
# DP-4
## Problem1:(https://leetcode.com/problems/maximal-square/)

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:


1 0 1 0 0

1 0 1 1 1

1 1 1 1 1

1 0 0 1 0

Output: 4

SPACE- 0(MN)
TIME - O(MN)
"""
#BRUTFORCE





#OPTIMAL
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0

        dp = [[0] * (len(matrix[0]) + 1) for i in range(len(matrix) + 1)]  #DP MATRIX
        m = len(matrix)
        n = len(matrix[0])
        _max = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == '1':        # check left diagonal and we keep on checking digonal form top left to bottom right
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                    _max = max(_max, dp[i][j])

        return _max * _max


