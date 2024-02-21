# Time Complexity :O(m×n)
# Space Complexity :O(m×n)
# Did this code successfully run on Leetcode :yes

from ast import List


def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        
        rows, cols = len(matrix), len(matrix[0])
        result = [[0] * (cols + 1) for _ in range(rows + 1)]
        max_size = 0

        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                if matrix[i - 1][j - 1] == '1':
                    result[i][j] = min(result[i - 1][j], result[i][j - 1], result[i - 1][j - 1]) + 1
                    max_size = max(max_size, result[i][j])

        return max_size * max_size