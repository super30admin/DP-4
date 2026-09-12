# Problem1:(https://leetcode.com/problems/maximal-square/)
# Time Complexity: O(m * n), We visit every cell in the grid exactly once and each cell does a constant amount of work (one comparison, one min, one addition). 
# Space Complexity: O(m * n),We build a dp table that is roughly the same size as the grid (one extra row and one extra column for padding). This extra table is what costs us the O(m * n) space.
# Approach:
# For every cell, we ask: "if this cell is the bottom right corner of a square, how big can that square be?" A square can only grow as large as its weakest side allows, so we look at the cell above, the cell to the left and the cell diagonally above-left, take the smallest of those three and add 1 for the current cell. 
# We keep track of the biggest square side seen anywhere in the grid and return its area at the end.
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)                       # number of rows in the grid
        n = len(matrix[0])                    # number of columns in the grid

        max = 0                               # tracks the biggest square side found so far
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        # dp table is one row and one column bigger than the grid
        # that extra row/column stays 0 and acts as "no neighbor exists here"
        # this avoids writing separate boundary checks for row 0 / column 0

        for i in range(1, m + 1):             # i maps to grid row (i - 1), starts at 1 because of padding
            for j in range(1, n + 1):         # j maps to grid column (j - 1), starts at 1 because of padding
                if matrix[i - 1][j - 1] == "1":
                    # only build a square here if the actual grid cell is a 1
                    # subtract 1 from i and j since matrix has no padding, but dp does

                    top = dp[i - 1][j]        # square ending directly above this cell
                    left = dp[i][j - 1]       # square ending directly to the left of this cell
                    top_left = dp[i - 1][j - 1]  # square ending diagonally above-left of this cell

                    dp[i][j] = 1 + min(top, left, top_left)
                    # the smallest of the three neighbors decides how far this square can extend
                    # add 1 to include the current cell itself in the square

                    max = max if max > dp[i][j] else dp[i][j]
                    # keep max updated to the biggest square side seen so far

        return max * max   # convert side length to area (side * side)