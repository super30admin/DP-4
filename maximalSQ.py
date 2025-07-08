"""
Apply dp[i][j] for size of the largest square ending at cell (i, j)
If matrix[i][j] == "1", then dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
Track maximum value seen in dp to compute the area
"""
"""
Time Complexity - O(m * n) – one pass through the matrix
Space Complexity - O(m × n) – for the dp table
"""

class maximalSQ:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0

        rows, cols = len(matrix), len(matrix[0])
        dp = [[0] * (cols + 1) for _ in range(rows + 1)]
        max_side = 0

        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(
                        dp[i][j-1], dp[i-1][j], dp[i-1][j-1]
                    ) + 1
                    max_side = max(max_side, dp[i][j])

        return max_side * max_side

if __name__ == "__main__":
    matrix = [
      ["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]
    ]
    obj = maximalSQ()
    print(obj.maximalSquare(matrix))
