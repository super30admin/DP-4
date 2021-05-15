class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        R, C = len(matrix), len(matrix[0])
        dp = [[0] * (C + 1) for _ in range(R + 1)]
        max_val = 0
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                max_val = max(max_val, dp[i][j])
        return max_val * max_val
