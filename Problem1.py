# Time Complexity : O(MN^2) (Where M is no of row and N is no of column)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# Brute force solution:
# - Start with every cell that is 1 and make length of square 1.
# - Expand row and column by square length and if any of the cell is 0 than break out of the loop, otherwise increment square length.
# - Update square length accordingly.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
#       initialize max row and column with current max square as 0.
        maxrow = len(matrix)
        maxcol = len(matrix[0])
        mxsqr = 0
#       Parse through each cell of the matrix
        for rowindex in range(maxrow):
            for colindex in range(maxcol):
#               If cell is 1 than set square length to 1 and make is_square flag true
                if matrix[rowindex][colindex] == "1":
                    sqrlen = 1
                    is_square = True
#                   Iterate over row and column till row + sqrlen and col + sqrlen.
                    while( rowindex + sqrlen < maxrow and colindex + sqrlen < maxcol and is_square):
                        for row in range(rowindex, rowindex + sqrlen + 1):
#                           If cell is 0 than set flag to false and break out of loop
                            if matrix[row][colindex + sqrlen] == "0":
                                is_square = False
                                break
                        for col in range(colindex, colindex + sqrlen + 1):
#                           If cell is 0 than set flag to false and break out of loop
                            if matrix[rowindex + sqrlen][col] == "0":
                                is_square = False
                                break
#                       If we pass through both loops that means all cell are one so increment square length
                        if is_square:
                            sqrlen += 1
#                   Update square length
                    mxsqr = max(mxsqr, sqrlen)
#       Return area of square
        return mxsqr * mxsqr
                
