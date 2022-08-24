#221. Maximal Square
"""
Time Complexity : O(m * n)
Space Complexity : O(1) #changing in same matrix

"""

"""
[["1","0","1","0","0"], ["1","0","1","1","1"],["1","1","1","1","1"],["1","1","1","1","1"],["1","1","1","1","0"]]
"""

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
       # print(matrix[2].count("1"))
        
        count = 0
        #base case i.e. there are no "1"s in matrix
        for i in matrix:
            if i.count("1") > 0:
                count += 1
                
        if count == 0:
            return 0
        
        m = 1 #maximal square
        #iterate loop leaving last row and column 
        for r in range(0, len(matrix) - 1):
            for c in range(0, len(matrix[0]) - 1):
                #print(r, c, "Hello")
                #get 4 values
                right = int(matrix[r][c+1])
                
                bottom = int(matrix[r+1][c])
                
                diagonal = int(matrix[r+1][c+1])
                
                current = int(matrix[r][c])
                #print(current, right, bottom, diagonal)
                
                #check 3 values for 0s
                if right != 0 and bottom != 0 and diagonal != 0 and current != 0:
                    #print( min(right, bottom, current))
                    matrix[r+1][c+1] = str(1 + min(right, bottom, current))
                    m = max(m, int(matrix[r+1][c+1]))
                    
                    
        print(matrix)        
        return m*m
