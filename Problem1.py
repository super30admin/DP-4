#In this code, I solved the "Maximal Square" problem using dynamic programming. I initialized a dp array with an extra row and column of 0s to handle boundaries. I iterated through the matrix from bottom-right to top-left, and for each cell containing '1', I updated the dp array with the value 1 plus the minimum of its right, bottom, and bottom-right neighbors in dp. This approach ensures that only cells forming a square contribute to the size calculation. The maximum side length found is then squared to get the area of the largest square. The time complexity is O(nm), and the space complexity is also O(nm) due to the dp array.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n_row, n_col = len(matrix), len(matrix[0])
        dp = [[0] * (n_col+1) for _ in range(n_row+1)]

        max_side = 0
        for i in range(n_row - 1, -1, -1):
            for j in range(n_col - 1, -1, -1):
                if matrix[i][j] == "1":
                    dp[i][j] = 1 + min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])
                    max_side = max(max_side, dp[i][j])
        return max_side **2


             