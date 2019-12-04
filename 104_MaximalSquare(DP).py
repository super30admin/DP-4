# Accepted on leetcode(221)
# time - O(m*n)
# space - O(m*n)
# Create a dp array of zeros with dimensions one more row and column than given matrix. Then, replace the values in dp matrix with minimum of above 3 sides and add 1 to it for current position. NAd at the end return the maximum number in dp matrix(area of that square).

class Solution:
    def maximalSquare(self, matrix) -> int:
        rows = len(matrix)

        # edge case
        if rows == 0: return 0

        cols = len(matrix[0])
        maximum = 0
        dp = [[0 for i in range(cols + 1)] for j in range(rows + 1)]

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    maximum = max(maximum, dp[i][j])
        return maximum * maximum