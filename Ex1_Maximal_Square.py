# ----------------------------------------------------
# Intuition:
#
# Goal: Find the area of the largest square of '1's in a 2D binary matrix.
#
# 1. Optimal DP (Bottom-Up):
#    - For each cell, we build up the size of the square ending at (i,j)
#      based on the min of top, left, and top-left neighbors.
#    - Formula: dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
#    - We use an extra row and column (dp size (m+1) x (n+1)) to avoid bounds checking.
#    → Time: O(m × n), Space: O(m × n) → Optimizable to O(n)
#
# 2. Brute Force:
#    - For each cell that's '1', expand a square as far as possible checking boundaries.
#    - For each expansion, scan the newly added row and column to check all '1's.
#    → Time: O(m × n × min(m, n)), Space: O(1)
# ----------------------------------------------------

from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0

        rows, cols = len(matrix), len(matrix[0])
        dp = [[0] * (cols + 1) for _ in range(rows + 1)]
        max_side = 0

        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(
                        dp[i - 1][j],     # top
                        dp[i][j - 1],     # left
                        dp[i - 1][j - 1]  # top-left
                    ) + 1
                    max_side = max(max_side, dp[i][j])

        return max_side * max_side

    # ----------------------------------------------------
    # 💬 Brute Force (Naive Expansion)
    # ----------------------------------------------------
    # def maximalSquare(self, matrix: List[List[str]]) -> int:
    #     if not matrix:
    #         return 0
    #     
    #     rows, cols = len(matrix), len(matrix[0])
    #     max_len = 0
    #     
    #     for i in range(rows):
    #         for j in range(cols):
    #             if matrix[i][j] == '1':
    #                 size = 1
    #                 flag = True
    #                 while i + size < rows and j + size < cols and flag:
    #                     for k in range(j, j + size + 1):
    #                         if matrix[i + size][k] == '0':
    #                             flag = False
    #                             break
    #                     for k in range(i, i + size):
    #                         if matrix[k][j + size] == '0':
    #                             flag = False
    #                             break
    #                     if flag:
    #                         size += 1
    #                 max_len = max(max_len, size)
    #     
    #     return max_len * max_len


# ----------------------------------------------------
# Main function for testing
# ----------------------------------------------------
if __name__ == "__main__":
    sol = Solution()

    matrix1 = [
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]
    ]
    print("Test 1 Output:", sol.maximalSquare(matrix1))  # Expected: 4

    matrix2 = [
        ["0","1"],
        ["1","0"]
    ]
    print("Test 2 Output:", sol.maximalSquare(matrix2))  # Expected: 1

    matrix3 = [["0"]]
    print("Test 3 Output:", sol.maximalSquare(matrix3))  # Expected: 0

    matrix4 = [
        ["1","1","1","1"],
        ["1","1","1","1"],
        ["1","1","1","1"]
    ]
    print("Test 4 Output:", sol.maximalSquare(matrix4))  # Expected: 9