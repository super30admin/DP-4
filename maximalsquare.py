# Time Complexity : O(M*N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if matrix ==None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxvalue = 0
        for i in range(m):
            maxvalue = max(maxvalue,int(matrix[i][0]))
        for i in range(n):
            maxvalue = max(maxvalue,int(matrix[0][i]))
        for i in range(1,m):
            for j in range(1,n):
                
                if matrix[i][j] == '1':
                    matrix[i][j] = str(min(min(int(matrix[i][j-1]),int(matrix[i-1][j])),int(matrix[i-1][j-1]))+1)
                    maxvalue = max(maxvalue,int(matrix[i][j]))
        
        return maxvalue**2
    
    
                
                    
                    
                    
                    
                    
                
                
        