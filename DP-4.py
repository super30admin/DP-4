# DP-4
## Problem1:(https://leetcode.com/problems/maximal-square/)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows, cols = len(matrix), len(matrix[0]) # Get the dimensions of the matrix
        dp = [[0] * (cols + 1) for _ in range(rows + 1)] # Initialize DP table with extra row and column
        max_side_length = 0 # Maximum side length of a square of '1's

        for row in range(rows):
            for col in range(cols):
                # Check if the current element is a '1'
                if matrix[row][col] == '1':
                    # Update the DP table by considering the top, left, and top-left neighbors
                    dp[row + 1][col + 1] = min(
                        dp[row][col + 1],     # Top
                        dp[row + 1][col],     # Left
                        dp[row][col]          # Top-Left
                    ) + 1
                    # Update the max side length found so far
                    max_side_length = max(max_side_length, dp[row + 1][col + 1])
      
        # Return the area of the largest square
        return max_side_length * max_side_length
# TC = O(m * n), SC = O(m * n)

## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        array_length = len(arr)
        dp = [0] * (array_length + 1)
        for i in range(1, array_length + 1):
            max_element = 0
            for j in range(i, max(0, i - k), -1):
                max_element = max(max_element, arr[j - 1])
                dp[i] = max(dp[i], dp[j - 1] + max_element * (i - j + 1))
        return dp[array_length]
# TC = O(n * k), SC = O(n)