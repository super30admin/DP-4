# Time Complexity: O(m * n)
# Space Complexity: O(m * n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if (matrix is None) or (len(matrix) < 1):
            return 0
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [([0] * (cols+1)) for _ in range(rows + 1)]
        maxside = 0
        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == '1':
                    dp[r + 1][c + 1] = (min(dp[r][c], dp[r + 1][c], (dp[r][c + 1])) + 1)
                    maxside = max(maxside, dp[r + 1][c + 1])
        return (maxside * maxside)