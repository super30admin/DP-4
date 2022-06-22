'''
Time Complexity: Exhaustive
Space Complexity: 0(m*n) + factor of recursive stack
'''

class Solution:
    
    def __init__(self):
        # result to return
        self.largestSq = 0
        
        # to chk neighbors of 1
        self.dirMatrix = [
            [0,1], # right
            [1,1], # right-diagonal
            [1,0], # bottom
        ]
        
    def chkSquare(self,ceiling_i,ceiling_j,matrix,i,j,count=0):
        # base-case
        if i == len(matrix) or j == len(matrix[0]):
            # out of bounds
            return count
        # self chk
        elif matrix[i][j] != "1":
            return count
        
        # logic-case
        # boolean flag
        flag = True
        
        # chk above
        temp_i = i-1
        
        while temp_i >= ceiling_i:
            if matrix[temp_i][j] != '1':
                flag = False
                break
            temp_i -= 1 
        
        # chk left 
        if flag == True:
            temp_j = j-1
            
            while temp_j >= ceiling_j:
                if matrix[i][temp_j] != '1':
                    flag = False
                    break
                temp_j -= 1
        
        # my flag is true
        if flag == True:
            count += 1
            return self.chkSquare(ceiling_i,ceiling_j,matrix,i+1,j+1,count)
        else:
            return count
        
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        # 1. iterate the matrix to find matrix[i][j] == 1
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                # chk the neignbors
                if matrix[i][j] == '1':
                    # local length count
                    length = 1
                    # set ceiling
                    ceiling_i = i
                    ceiling_j = j
                    # call function to chk for largest sq, it returns the length
                    length += self.chkSquare(ceiling_i,ceiling_j,matrix,i+length,j+length)
                    # chk for largestSq
                    if self.largestSq == None or self.largestSq < length:
                        self.largestSq = length
        
        # print the largestSq
        # print(f"Largest sq is:\t{self.largestSq}")
        # print(f"Area of square is:\t {self.largestSq*self.largestSq}")
        return (self.largestSq*self.largestSq)