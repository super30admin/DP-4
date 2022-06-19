# TC - O(m * n)
# SC - O(m * n)
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0 for i in range(cols+1)] for j in range(rows+1)]

        max_side = 0

        for row in range(1, rows+1):
            for col in range(1, cols+1):
                if matrix[row-1][col-1] != "0":
                    above = dp[row-1][col]
                    above_left = dp[row-1][col-1]
                    left = dp[row][col-1]
                    dp[row][col] = min(above, above_left, left) + 1
                    max_side = max(max_side, dp[row][col])
        return max_side * max_side
