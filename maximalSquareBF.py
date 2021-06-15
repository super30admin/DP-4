class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None:
            return None
        
        m,n = len(matrix), len(matrix[0])
        maxVal = 0
        for i in range(0, m):
            for j in range(0,n):
                flag = False
                if matrix[i][j] == '1':
                    curr = 1
                    flag = True
                    
                    while i+curr<m and j+curr<n and flag:
                        #check in same col and row of the diagonal element
                        for k in range(i+curr,i-1,-1):
                            if matrix[k][j+curr]== '0':
                                flag = False
                                break
                        for k in range(j+curr,j-1,-1):
                            if matrix[i+curr][k]== '0':
                                flag = False
                                break
                                
                        if flag:
                            curr+=1
                        
                    maxVal = max(maxVal, curr)
                    
        return maxVal*maxVal
                    
                
#    time complexity of this approach is O(mn)2     
        
