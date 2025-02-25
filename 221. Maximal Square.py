#space: O (1)
#Time: O(m*n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m= len(matrix)
        n=len(matrix[0])
        dp= [[0] * (n+1) for _ in range(m+1) ]
        mx=0
        for i in range(1,m+1):
            for j in range(1, n+1):
                if(matrix[i-1][j-1] == '1'):
                    dp[i][j]= min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1
                mx= max(mx, dp[i][j])
        return mx*mx
