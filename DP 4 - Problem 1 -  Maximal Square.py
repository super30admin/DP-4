"""
FAANMG Problem #107 {Medium} 

221. Maximal Square


# Time complexity : O(m*n)^2 -- traversing all cell and for each cell checking the validity
# Space complexity : O(1) 

Did this code successfully run on Leetcode : Yes

Time Limit Exceeded

In this approach we iterate through each row and col till we meet a "1" 
and then we  again iterate from its downwards diag to upwards (Ceiling) and left(walls)






@name: Rahul Govindkumar_RN27JUL2022
"""   

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if matrix ==None or len(matrix)==0:
            return 0
        
        #initilize boundaries
        row_len = len(matrix)
        col_len = len(matrix[0])
        
        #flag to check if we hit 1
        flag = False
        
        square = 0
        
        #iterate throung the matrix
        for r in range(row_len):
            for c in range(col_len):
                
                if matrix[r][c]=='1':
                    
                    flag = True
                    
                    #used to help incrementing by row and col
                    k=1
                    
                    #Checking boundary condition                  
                    while (r+k < row_len and c+k < col_len):
                        
                        #check for 1's in same coln
                        for i in range( (r+k) , (r-1) , -1):
                            
                            if matrix[i][c+k] =="0":
                                flag=False
                                break
                        
                        #check for 1's in same row
                        for j in range( (c+k) , (c-1) , -1):
                            
                            if matrix[r+k][j] =="0":
                                flag=False
                                break
                                
                        if flag:
                            k +=1
                            
                    square=max(square,k)
                    
        return square * square
                                
        
"""
FAANMG Problem #107 {Medium} 

221. Maximal Square


# Time complexity : O(m*n)
# Space complexity : O(m*n) 

Did this code successfully run on Leetcode : Yes


DP Solution
Using bottom up DP and taking the minimum of upward diag, upward and left cells

@name: Rahul Govindkumar_RN27JUL2022
"""           
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if matrix ==None or len(matrix)==0:
            return 0
        
        #initilize boundaries
        row_len = len(matrix)
        col_len = len(matrix[0])
        
        #flag to check if we hit 1
        flag = False
        
        square = 0
        
        dp =[[0 for _ in range (col_len+1)] for _ in range(row_len+1)]
        
        
        #iterate throung the matrix
        for i in range(1,row_len+1):
            for j in range(1,col_len+1):
                
                if matrix[i-1][j-1]=='1':
                    
                    dp[i][j] = 1 + int(min( dp[i-1][j-1] , min( dp[i-1][j] , dp[i][j-1])))
                    square = max(square, dp[i][j])
                    
                    
                            
                   
                    
        return square * square
                                
        
 """
FAANMG Problem #107 {Medium} 

221. Maximal Square


# Time complexity : O(m*n)
# Space complexity : O(1) 

Did this code successfully run on Leetcode : Yes


DP Solution with constant time
Using bottom up DP and taking the minimum of upward diag, upward and left cells

@name: Rahul Govindkumar_RN27JUL2022
"""         
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if matrix ==None or len(matrix)==0:
            return 0
        
        #initilize boundaries
        row_len = len(matrix)
        col_len = len(matrix[0])
        
        #flag to check if we hit 1
        flag = False
        
        square = 0
        
        # check for top row columns
        for i in range(col_len):
            if matrix[0][i] == "1": 
                square = 1

        # check for left most col each row
        for i in range(row_len):
            if matrix[i][0] == "1": 
                square = 1
        
        
        #iterate throung the matrix
        for i in range(1,row_len):
            for j in range(1,col_len):
                
                if matrix[i][j]=='1':
                    
                    diag = int(matrix[i - 1][j -1])
                    left = int(matrix[i][j -1])
                    up   = int(matrix[i - 1][j])
                    sq = 1 + min(diag, min(left, up))
                    matrix[i][j] = str(sq)
                    square = max(square, sq)
           
        return square * square
                                
        
        
        
                
                
        