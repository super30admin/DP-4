"""
Time complexity O(MN)^2
Space complexity O(1)
"""


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix)==0:
            return matrix
        m=len(matrix)
        n=len(matrix[0])
        flag=False
        maxarea=0
        for i in range(m):
            for j in range(n):
                if(matrix[i][j]=='1'):
                    flag=True
                    curr=1
                    while(i+curr<m and j+curr <n and flag):
                        for k in range(i+curr,i-1,-1):
                            if(matrix[k][j+curr]=='0'):
                                flag=False
                                break
                        for k in range(j+curr,j-1,-1):
                            if(matrix[i+curr][k]=='0'):
                                flag=False
                                break
                        if flag!=False:
                            curr+=1
                    maxarea =max(maxarea,curr)
        return maxarea*maxarea  
                            
                            
                                
        