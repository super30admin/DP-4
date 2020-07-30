#Brute Force is O(m*m*n*n) time complexity
#Space is O(1)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix==None and len(matrix)==0:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        flag=False
        max1=0
        for i in range(m):
            for j in range(n):
                if matrix[i][j]=='1':
                    curr=1
                    flag=True
                while i+curr <m and j+curr<n and flag:
                    #column
                    for k in range(i+curr,i-1,-1):
                        if matrix[k][j+curr]=='0':
                            flag=False
                            
                    #row
                    for k in range(j+curr,j-1,-1):
                        if matrix[i+curr][k]=='0':
                            flag=False
                    
                    if flag:
                        curr+=1
                max1=max(max1,curr)
        return max1*max1
        
#Dp solution
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix==None or len(matrix)==0:
            return 0
        max1=0
        m=len(matrix)
        n=len(matrix[0])
        dp=[[0 for i in range(m+1)] for j in range(n+1)]
        
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=1+min(dp[i-1][j],min(dp[i-1][j-1],dp[i][j-1]))
                    max1=max(max1,dp[i][j])
        return max1*max1
    #time is O(n2)
    #space is O(n2)
