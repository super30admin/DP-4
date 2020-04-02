'''
Solution:
1.  A cell having a 0 can't form a square and a cell having 1 can form a minimum of 1-sized square
    and maximum depends on its neighboring cells.
2.  Recurrence Relation:
    
    cell[row][col]      =   minimum {cell[row][col-1], cell[row-1][col-1], cell[row-1][col]}
    only if value = 1
3.  Maintain a max variable to update the maximum seen do far, return the square of it.

Time Complexity:    O(m x n)
Space Complexity:   O(m x n)

--- Passed all testcases successfully on leetcode.
'''


class MaximalSquare:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        #   edge case check
        if (matrix == None or len(matrix) == 0):
            return 0
        
        #   initialize required variables and final matrix
        rows = len(matrix)
        cols = len(matrix[0])
        dpMatrix = [ [0 for c in range(cols)] for r in range(rows) ]
        maxSoFar = 0
        
        #   fill first row as it is [0 or 1]
        for col in range(cols):
            dpMatrix[0][col] = int(matrix[0][col])
            maxSoFar = max(maxSoFar, dpMatrix[0][col])
        
        #   fill first column as it is [0 or 1]        
        for row in range(rows):
            dpMatrix[row][0] = int(matrix[row][0])
            maxSoFar = max(maxSoFar, dpMatrix[row][0])
        
        #   fill the matrix with the above mentioned formula for cells with 1 and 0 if cell is 0.    
        for r in range(1, rows):
            for c in range(1, cols):
                if (matrix[r][c] == '0'):
                    dpMatrix[r][c] = 0
                else:
                    dpMatrix[r][c] = 1 + min(dpMatrix[r][c-1], dpMatrix[r-1][c], dpMatrix[r-1][c-1])
                    maxSoFar = max(maxSoFar, dpMatrix[r][c])
        
        #   return the max size sqaured value            
        return (maxSoFar * maxSoFar)
                    