#Time complexity: O(m*n)
# Space complexity: O(m*n)

# The intuition is simple for the bottom up approach, a total number of square at a given row,col if the value is 1 is 1 + minimum of the down, diag down and right row columns
# respectively. Hence, we iterate from the last row and col and calculate the number of squares possible keeping in mind the max squares at even given iteration and return the square of that finally

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        maxVal = 0
        for r in range(m - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                if matrix[r][c] == "1":
                    dp[r][c] = 1 + min(dp[r][c + 1], dp[r + 1][c + 1], dp[r + 1][c])
                    maxVal = max(maxVal, dp[r][c])

        return maxVal * maxVal

    # Same intuition, time is same O(m*n) but space is O(n)
    def maximalSquareOptimizedSpace(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        dp = [0] * (n + 1)
        maxVal = 0
        for r in range(m - 1, -1, -1):
            diagDown = 0
            for c in range(n - 1, -1, -1):
                if matrix[r][c] == "1":
                    temp = dp[c]
                    dp[c] = 1 + min(dp[c], dp[c + 1], diagDown)
                    diagDown = temp
                    maxVal = max(maxVal, dp[c])
                else:
                    dp[c] = 0

        return maxVal * maxVal