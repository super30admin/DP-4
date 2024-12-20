# Approach:
# We use dynamic programming to find the largest square of 1's in the matrix.
# 1. Define a DP table `dp` where `dp[i][j]` represents the side length of the largest square 
#    whose bottom-right corner is at position (i, j).
# 2. If `matrix[i][j]` is '1', the value of `dp[i][j]` is determined by the minimum of its top, 
#    left, and top-left neighbors + 1.
# 3. Track the maximum value in the DP table, which gives the side length of the largest square.
# 4. The area is the square of this maximum side length.

# Time Complexity: O(m * n), where m is the number of rows and n is the number of columns, 
#                  as we traverse the matrix once.
# Space Complexity: O(m * n) for the DP table. This can be optimized to O(n) by using a single row.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # Edge case: empty matrix
        if not matrix or not matrix[0]:
            return 0
        
        # Dimensions of the matrix
        m, n = len(matrix), len(matrix[0])
        
        # Initialize a DP table with all zeroes
        dp = [[0] * n for _ in range(m)]
        max_side = 0  # To track the maximum side length of a square
        
        # Iterate through each cell in the matrix
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:  # Base case for first row or first column
                        dp[i][j] = 1
                    else:
                        # Update the DP value based on neighbors
                        dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    
                    # Update the maximum side length found so far
                    max_side = max(max_side, dp[i][j])
        
        # Return the area of the largest square
        return max_side * max_side
