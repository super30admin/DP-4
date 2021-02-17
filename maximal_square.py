# Approach: Brute Force iterate over the matrix in O(M^2 N^2) Time and check along the diagnols, keeping track of the square size obtained at every iteration
# Space - O(1)
# Time is O( M^2 * N^2) as we keep taking the decisions on every elemement on the diagnol in an exponential manner

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if not matrix or len(matrix) == 0:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        max_val = 0
        flag = False
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    current = 1
                    flag = True
                    
                    # traversing from an element on diagnol up until rows and cols
                    while (i + current < rows and j + current < cols and flag):
                        
                        # checking on columns
                        for k in range(i, i + current + 1):
                            if matrix[k][j + current] == '0':
                                flag = False
                                break

                        # checking on rows      
                        for k in range(j, j + current + 1):
                            if matrix[i + current][k] == '0':
                                flag = False
                                break

                        # if flag is true we expand the diagnol so current += 1     
                        if flag:
                            current += 1
                            
                    max_val = max(max_val, current)
                    
        return max_val ** 2 # since we need to return the area
                        
        
## DP Solution where we make use of repeated subproblems
# Time - O(M * N)
# Space - O(M * N)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if not matrix or len(matrix) == 0:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])

        dp = [[0 for _ in range(cols + 1)] for i in range(rows + 1)] 
        
        size = 0
        
        # iterate 1 onwards as zero is the dummy reference we introduced
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):

                # to solve out of bounds error we refer i-1, j-1, due to dummy ref
                if matrix[i-1][j-1] == "1":
                    # dp of current index will be 1 + min(dp val prev row, same row, prev col, and prev row, prev col)
                    dp[i][j] = min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1])) + 1
                
                size = max(size, dp[i][j])
                          
        
        return size * size