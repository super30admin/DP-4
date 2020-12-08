# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Approach: Store the maximum size square for every cell by taking the min of three directions + 1 in a DP table.
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) < 1:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        dp = [[0]*(cols+1) for _ in range(rows+1)]
        max_side = 0
        
        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == '1':
                    dp[r+1][c+1] = min(dp[r][c], dp[r+1][c], dp[r][c+1]) + 1
                    max_side = max(max_side, dp[r+1][c+1])

        return max_side * max_side