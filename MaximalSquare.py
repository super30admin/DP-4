#Time compelxity: O(mn)
#Space complexity: O(mn)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m,n=len(matrix),len(matrix[0])
        dp=[[0 for i in range(n+1)] for j in range(m+1)]
        maxi=0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=min(int(dp[i-1][j]),int(dp[i][j-1]),int(dp[i-1][j-1]))+1
                    maxi=max(maxi,dp[i][j])
        return maxi*maxi
    
#Time complexity: O(mn)
#Space complexity: O(n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m,n=len(matrix),len(matrix[0])
        dp=[0 for i in range(n+1)]
        dp1=dp.copy()
        maxi=0
        for i in range(m):
            dp1=[0]*(n+1)
            for j in range(1,n+1):
                if matrix[i][j-1]=='1':
                    dp1[j]=min(dp1[j-1],dp[j],dp[j-1])+1
                    maxi=max(dp1[j],maxi)
            dp=dp1
        return maxi*maxi    
                    
                    
        