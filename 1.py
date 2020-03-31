# Time complexity: O(n ^ 2) where n is the size of a row
# Space complexity: O(n ^ 2) where n is the size of a row

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        dp = [[0 for j in range(len(matrix[0]))] for i in range(len(matrix))]

        max_square = 0

        for j in range(len(matrix[0])):
            dp[0][j] = int(matrix[0][j])
            max_square = max(dp[0][j], max_square)

        for i in range(len(matrix)):
            dp[i][0] = int(matrix[i][0])
            max_square = max(dp[i][0], max_square)

        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if matrix[i][j] == '1':
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                else:
                    dp[i][j] = 0
                max_square = max(dp[i][j], max_square)

        return max_square ** 2