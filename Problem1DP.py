# Time Complexity : O(MN) (Where M is no of row and N is no of column)
# Space Complexity : O(MN) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# DP Solution
# - Every cell represents lower righ most corner of square and it stores square length.
# - Square is possible with current cell only if left cell, upper cell and left upper diagonal cell is also square.
# - So add 1 to minimum of these 3 neighbour. Check only for cell with 1 value.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        mxrow = len(matrix)
        mxcol = len(matrix[0])
        sqln = 0
#       Make dp matrix with 0 value in all cell
        dp = [[0 for i in range(mxcol)] for j in range(mxrow)]
        
#       Parse through each cell where it's value is 1.
        for row in range(mxrow):
            for col in range(mxcol):
                if matrix[row][col] == '1':
#                   This condition covers first row and column. In that case we want to put 1 as it is.
                    if row - 1 >= 0 and col - 1 >= 0:
#                       Taking minimum of left cell, upper cell and left upper diagonal cell and adding 1 into it.
                        dp[row][col] = min(dp[row-1][col], dp[row][col-1], dp[row-1][col-1]) + 1
                    else:
                        dp[row][col] = 1
#                   Updating square length with current value.
                    sqln = max(sqln, dp[row][col])
#       return area of square
        return sqln * sqln
