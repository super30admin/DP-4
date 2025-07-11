"""
I implemented the DP approach to find the area of the largest square containing only 1s. I used a 2D DP table where dp[i][j] stores the side length of the largest square  
that ends at position (i-1, j-1) in the matrix.  For each cell with '1', we check the minimum of its top, left, and top-left neighbors and add 1 to it. The maximum side length found is then squared to get the area.
Time Complexoty: O(mn)
Space COmplexoty: O(mn)
"""
class Solution:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        
        if not matrix or not matrix[0]:
            return 0

        rows, cols = len(matrix), len(matrix[0])
        dp = [[0] * (cols + 1) for _ in range(rows + 1)]
        max_len = 0

        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(
                        dp[i - 1][j],      #top
                        dp[i][j - 1],      #left
                        dp[i - 1][j - 1]   #top-left
                    ) + 1
                    max_len = max(max_len, dp[i][j])

        return max_len * max_len