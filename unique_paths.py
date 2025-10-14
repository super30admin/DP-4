class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # dp=[[0 for _ in range(n)] for _ in range(m)]
        dp=[0]*n
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i==m-1 or j==n-1:
                    dp[j]=1
                else:
                    dp[j]=dp[j+1]+dp[j]
        return dp[0]

        