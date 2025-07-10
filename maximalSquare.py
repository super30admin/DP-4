# TC: O(m*n)
# SC: O(n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        dp=[0]*(len(matrix[0])+1)
        mres=0
        for row in range(len(matrix)-1,-1,-1):
            diagDown=0
            for col in range(len(matrix[0])-1,-1,-1):
                temp=dp[col]
                if matrix[row][col]=='1':
                    dp[col]=min(diagDown, dp[col+1], dp[col])+1
                    mres=max(mres,dp[col])
                else:
                    dp[col]=0
                diagDown=temp
        return mres**2

