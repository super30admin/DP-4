# Time Complexity: O(rows*cols)
# Space Complexity: O(rows*cols)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        
        rows, cols = len(matrix), len(matrix[0])
        max_side = 0
        area_matrix = [[0] * cols for _ in range(rows)]
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        area_matrix[i][j] = 1
                    else:
                        area_matrix[i][j] = min(area_matrix[i-1][j], area_matrix[i][j-1], area_matrix[i-1][j-1]) + 1
                    max_side = max(max_side, area_matrix[i][j])
        
        return max_side * max_side
