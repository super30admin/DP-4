# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Approach as we have repeated subproblems. Initialize dp matrix m+1 * n+1 with 0 as the first row and column will be 0
# Iterate over the matrix rows and colums.
# Check if matrix[i][j] == 1 dp[i+1][j+1] will be the minimum between the (upper diagonal, previous row and previous column) + 1
# Get the maxlength for each dp[i+1][j+1]
# Return maxlength * maxlength


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxlength = 0
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == "1":
                    dp[i +
                       1][j +
                          1] = 1 + min(dp[i][j + 1], dp[i + 1][j], dp[i][j])
                    maxlength = max(maxlength, dp[i + 1][j + 1])

        return maxlength * maxlength
