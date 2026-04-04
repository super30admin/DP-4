# Time Complexity : O(m *n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We just keep one row of DP and move from left to right while updating each cell.
# We also track the diagonal-up value from the previous row to calculate the square side.
# This saves space and still gives us the correct biggest square ending at any cell.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        
        diagUp, maxVal = 0, 0

        dp = [0] * (n+1)

        for i in range(1, m+1):
            for j in range(1, n+1):
                temp = dp[j]
                if matrix[i-1][j-1] == '1':
                    dp[j] = 1 + min(dp[j], min(dp[j-1], diagUp))
                    maxVal = max(maxVal, dp[j])
                else:
                    dp[j] = 0
                diagUp = temp

        return maxVal * maxVal

        