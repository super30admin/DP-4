# The maximalSquare method finds the area of the largest square containing only 1s in a binary matrix.

# Use dynamic programming:
# - `dp[i][j]` represents the size of the largest square whose bottom-right corner is at (i, j).
# - If `matrix[i][j]` is '1':
#   - At the first row or column, the value is 1.
#   - Otherwise, compute the size using the minimum of the top, left, and top-left dp values plus 1.
# - Track the maximum size of squares during the traversal.

# Return the area of the largest square (`max_size^2`).

# TC: O(m * n) - Each cell in the matrix is processed once.
# SC: O(m * n) - Space for the dp table.


from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        max_size = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    max_size = max(max_size, dp[i][j])
        return max_size * max_size
