"""
Leetcode: https://leetcode.com/problems/maximal-square/
Approach: Dynamic Programming
Time complexity : O(mn). Single pass.
Space complexity : O(mn). Another matrix of same size is used for dp.
"""


class Solution:
 def maximalSquare(self, matrix: List[List[str]]) -> int:
     if not matrix:
         return 0

     maxRows = len(matrix)
     maxCols = len(matrix[0])
     maxLength = 0

     dp = [[0 for i in range(maxCols + 1)] for j in range(maxRows + 1)]

     for row in range(1, maxRows + 1):
         for col in range(1, maxCols + 1):

             if matrix[row - 1][col - 1] == '1':
                 dp[row][col] = min(dp[row - 1][col - 1], dp[row - 1][col], dp[row][col - 1]) + 1

                 maxLength = max(maxLength, dp[row][col])

     return maxLength * maxLength