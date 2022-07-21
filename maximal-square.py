# Time Complexity: O(m^2*n^2)
# Space Complexity: O(1)
class Solution:
    # def maximalSquare(self, matrix: List[List[str]]) -> int:
    #     n=len(matrix)
    #     m=len(matrix[0])
    #     maxi=0
    #     for i in range(n):
    #         for j in range(m):
    #             if matrix[i][j]=='1':
    #                 l=1
    #                 flag=True
    #                 while i+l<n and j+l <m and flag:
    #                     k=i+l
    #                     while k>=i:
    #                         if matrix[k][j+l]!='1':
    #                             flag=False
    #                             break
    #                         k-=1
    #                     k=j+l
    #                     while k>=j:
    #                         if matrix[i+l][k]!='1':
    #                             flag=False
    #                             break
    #                         k-=1
    #                     if flag:
    #                         l+=1
    #                 maxi=max(maxi,l)
    #     return maxi*maxi
# Time Complexity: O(m*n)
# Space Complexity: O(1)
    # def maximalSquare(self, matrix: List[List[str]]) -> int:
    #     n=len(matrix)
    #     m=len(matrix[0])
    #     maxi=0
    #     for i in matrix[0]:
    #         if i =='1': maxi=1
    #     for j in range(n):
    #         if matrix[j][0]=='1': maxi=1
    #     for i in range(1,n):
    #         for j in range(1,m):
    #             if matrix[i][j]=='1':
    #                 temp=1+min(int(matrix[i-1][j-1]),int(matrix[i][j-1]),int(matrix[i-1][j]))
    #                 matrix[i][j]=str(temp)
    #                 maxi=max(temp,maxi)
    #     return maxi*maxi
# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
    # def maximalSquare(self, matrix: List[List[str]]) -> int:
    #     n=len(matrix)
    #     m=len(matrix[0])
    #     maxi=0
    #     dp=[[0 for j in range(m+1)] for i in range(n+1)]
    #     for i in range(0,n):
    #         for j in range(0,m):
    #             if matrix[i][j]=='1':
    #                 dp[i+1][j+1]=1+min(dp[i][j],dp[i+1][j],dp[i][j+1])
    #                 maxi=max(dp[i+1][j+1],maxi)
    #     return maxi*maxi
# Time Complexity: O(m*n)
# Space Complexity: O(m), number of columns
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n=len(matrix)
        m=len(matrix[0])
        maxi=0
        dp=[0 for j in range(m+1)] 
        for i in range(0,n):
            upleft=0
            for j in range(0,m):
                if matrix[i][j]=='1':
                    temp=1+min(dp[j+1],dp[j],upleft)
                    upleft=dp[j+1]
                    dp[j+1]=temp
                    maxi=max(maxi,temp)
                else: dp[j+1]=0
        return maxi*maxi
                        
                    
                
        