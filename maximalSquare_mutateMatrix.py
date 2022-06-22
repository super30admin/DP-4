'''
Mutate the Matrix
Time Complexity: 0(m*n)
Space Complexity: 0(m*n)
'''
class Solution:
    
    def __init__(self):
        self.maxBound = 0
        
        self.dirMatrix = [
            [-1,0],  # above
            [-1,-1], # above-left
            [0,-1]   # left
        ]
        
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        # base-case
        # iterate row == 0
        for col in range(0,len(matrix[0])):
            if matrix[0][col] != '0':
                self.maxBound = int(matrix[0][col])
                
        # iterate col == 0
        for row in range(0,len(matrix)):
            if matrix[row][0] != '0':
                self.maxBound = int(matrix[row][0])
        
        # logic-case
        '''ignore row=0 and col=0'''
        # iterate the matrix and mutate 
        for row in range(1,len(matrix)):
            for col in range(1,len(matrix[0])):
                if matrix[row][col] != '0':
                    # base-case
                    if self.maxBound < int(matrix[row][col]):
                        self.maxBound = int(matrix[row][col])
                    
                    # logic-case
                    # chk 4 directions
                    flag = True
                    minVal = None
                    for pair in self.dirMatrix:
                        temp_i = row + pair[0]
                        temp_j = col + pair[1]
                        if matrix[temp_i][temp_j] != '0':
                            if minVal == None or minVal > int(matrix[temp_i][temp_j]):
                                minVal = int(matrix[temp_i][temp_j])
                        else:
                            flag = False
                            minVal = None 
                            break
                    '''end of for loop to chk self.dirMatrix'''
                    if flag == True:
                        matrix[row][col] = str(minVal+1)
                        if self.maxBound < int(matrix[row][col]):
                            self.maxBound = int(matrix[row][col])
                    
                else:
                    continue
        '''end of for loop both internal and external'''
        
        #print(f"max bound is:\t{self.maxBound}")
        #print(f"area is:\t{self.maxBound*self.maxBound}")
        
        return self.maxBound*self.maxBound
                                