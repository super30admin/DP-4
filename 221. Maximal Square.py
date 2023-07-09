#Time Complexity:O(n*m)
#Space Complexity:O(n*m)

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        n=len(matrix)
        m=len(matrix[0])
        dp=[[0]*(m+1) for i in range(n+1)]
        ans=0
        for r in range(n):
            for c in range(m):
                if matrix[r][c]=="1":
                    dp[r+1][c+1]=min(dp[r][c],dp[r+1][c],dp[r][c+1])+1
                    ans=max(ans,dp[r+1][c+1])
        return ans*ans