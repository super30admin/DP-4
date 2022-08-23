class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m=len(matrix)
        n=len(matrix[0])
        
        t=[[0 for _ in range(n+1)]for _ in range(m+1)]
        largest=0
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=='1':
                    t[i][j]=1+min(t[i-1][j],t[i][j-1],t[i-1][j-1])
                    if largest<t[i][j]:
                        largest=t[i][j]
                    
        return largest*largest