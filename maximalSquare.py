class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        maxNum = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == "0":
                    continue
                if i > 0 and j > 0:
                    left = int(matrix[i][j - 1])
                    topLeft = int(matrix[i - 1][j - 1])
                    top = int(matrix[i - 1][j])
                    matrix[i][j] = 1 + min(top, left, topLeft)
                maxNum = max(maxNum, int(matrix[i][j]))
        return maxNum * maxNum