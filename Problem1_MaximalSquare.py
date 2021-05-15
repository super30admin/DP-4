# Time Complexity: O(mn), where m - number of rows, n - number of columns
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        maximum = 0

        # Array to store the max size of the square with all 1's
        dp = [[0 for y in range(n + 1)] for x in range(m + 1)]

        # For every element, update the size of the square bounded by the min value
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1
                    # Update the maximum size
                maximum = max(maximum, dp[i][j])

        # Return the area of the square with max size
        return maximum * maximum