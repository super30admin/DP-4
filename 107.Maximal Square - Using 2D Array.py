class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        row = len(matrix)
        col = len(matrix[0])
        m = 0
        dp = [[0] * (col + 1) for i in range(row + 1)]
        print(len(dp), dp)
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = 1 + min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1]))
                    m = max(m, dp[i][j])
        return m * m

# 2D Array Solution
# Time Complexity : O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
