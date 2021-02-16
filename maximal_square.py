#Time Complexity: O(M * N)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No



class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        
        #curr max square length
        maxsq = 0
        
        #first row
        for i in matrix[0]:
            if i == "1":
                maxsq = 1
                break
        #first col
        if maxsq == 0:
            for i in range(rows):
                if matrix[i][0] == "1":
                    maxsq = 1
                    break
        
        #from second row and second col
        for i in range(1,rows):
            for j in range(1,cols):
                if matrix[i][j] == "1":
                    matrix[i][j] = str(min(int(matrix[i-1][j-1]),int(matrix[i-1][j]),int(matrix[i][j-1])) + 1)
                    if int(matrix[i][j]) > maxsq:
                        maxsq = int(matrix[i][j])
            
        return maxsq**2