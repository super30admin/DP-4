"""
DP approach --
- Create an extra matrix with m+1 rows and n+1 cols
- add 0's to 1st row and 1st col
- While traversing throught the original matrix, look in 3 dirs -> up, left, diagonal up
- If the element can't form a square of area more than 1, add one to the new matrix in 1st row-1st col
- If encounter 0, add 0 to nw matrix
- continue the same for rest of the elements.
- When you encounter an element which forms a square, take the minimum from its adj (up, left, diag up) and add 1 to it and add this val in new matrix
- Return maxVal*maxVal as the final output

TC - O(m*n)
SC = O(m*n) -- since creating extra matrix to calculate area
"""


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0: return 0

        m = len(matrix)
        n = len(matrix[0])
        maxArea = 0

        dp = [[0 for j in range(n + 1)] for i in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == '1':
                    # left, up, diagonal
                    # we add +1 since we are adding the minimum element from up/left/diagonal
                    # to current element which is 1
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
                    maxArea = max(maxArea, dp[i][j])

        return maxArea * maxArea