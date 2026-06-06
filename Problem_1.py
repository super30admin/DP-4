# class Solution:
#     def maximalSquare(self, matrix):
#         rows, cols = len(matrix), len(matrix[0])
#         memo = [[0 for _ in range(cols + 1)] for _ in range(rows + 1)]
#         maxLen = 0
#         for r in range(rows - 1, -1, -1):
#             for c in range(cols - 1, -1, -1):
#                 if matrix[r][c] == "1":
#                     memo[r][c] = 1 + min(
#                         memo[r + 1][c], memo[r][c + 1], memo[r + 1][c + 1]
#                     )
#                 maxLen = max(maxLen, memo[r][c])
#         return maxLen * maxLen


# class Solution:
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         rows, cols = len(matrix), len(matrix[0])
#         memo = [0 for _ in range(cols + 1)]
#         maxLen = 0
#         for r in range(rows - 1, -1, -1):
#             currElements = [0] * (cols + 1)
#             for c in range(cols - 1, -1, -1):
#                 if matrix[r][c] == "1":
#                     currElements[c] = 1 + min(memo[c], memo[c + 1], currElements[c + 1])
#                 maxLen = max(maxLen, currElements[c])
#             memo = currElements[:]
#         return maxLen * maxLen


class Solution:
    def maximalSquare(self, matrix):
        rows, cols = len(matrix), len(matrix[0])
        memo = [0 for _ in range(cols + 1)]
        maxLen = 0
        for r in range(rows - 1, -1, -1):
            diagonal = 0
            for c in range(cols - 1, -1, -1):
                temp = memo[c]
                if matrix[r][c] == "1":
                    memo[c] = 1 + min(memo[c], memo[c + 1], diagonal)
                else:
                    memo[c] = 0
                maxLen = max(maxLen, memo[c])
                diagonal = temp
        return maxLen * maxLen

