class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # Time Complexity: O(m*n)
        # Space Complexity: O(1)
        n=len(matrix)
        m=len(matrix[0])
        maxi=0
        for i in matrix[0]:
            if i =='1': maxi=1
        for j in range(n):
            if matrix[j][0]=='1': maxi=1
        for i in range(1,n):
            for j in range(1,m):
                if matrix[i][j]=='1':
                    temp=1+min(int(matrix[i-1][j-1]),int(matrix[i][j-1]),int(matrix[i-1][j]))
                    matrix[i][j]=str(temp)
                    maxi=max(temp,maxi)
        return maxi*maxi

#brutforce method
#TC: O(m^2+n^2) 
# class Solution(object):
#     def maximalSquare(self, matrix):
#         """
#         :type matrix: List[List[str]]
#         :rtype: int
#         """
        
#         if matrix==None or len(matrix)==0: return 0
#         i=0
#         j=0
#         k=0
#         row=len(matrix)
#         col=len(matrix[0])
#         maximum=0
#         for i in range(row):
#             for j in range((col)):
#                 if matrix[i][j]=="1":
#                     l=1
#                     flag=True
                    
#                     while(i+l<row and j+l<col and flag):
#                         #column
#                         for k in range(i,i+l+1):
#                             if matrix[k][j+l]=='0':
#                                 flag=False
#                                 break
#                         #row
#                         for k in range(j+l,j-1,-1):
#                             if matrix[i+l][k]=='0':
#                                 flag=False
#                                 break
#                         if flag: l+=1
#                     maximum=max(maximum,l)
#         return maximum*maximum

#DP using dp matrix
'''
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # Time Complexity: O(m*n)
        #Space Complexity: O(m*n)
        n=len(matrix)
        m=len(matrix[0])
        maxi=0
        dp=[[0 for j in range(m+1)] for i in range(n+1)]
        for i in range(0,n):
            for j in range(0,m):
                if matrix[i][j]=='1':
                    dp[i+1][j+1]=1+min(dp[i][j],dp[i+1][j],dp[i][j+1])
                    maxi=max(dp[i+1][j+1],maxi)
        return maxi*maxi
'''

#DP using dp matrix and optimizing the dp matrix
'''
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
'''