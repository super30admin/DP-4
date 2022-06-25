class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix)==0 or len(matrix[0])==0:
            return 0
        m,n=len(matrix)+1, len(matrix[0])+1
        maximum=0
        
        dp=[[0 for i in range(n)]for j in range(m)]
        
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=1 + min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
                    maximum=max(maximum,dp[i][j])
        return maximum * maximum
        
        