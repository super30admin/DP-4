"""
Check up, left and diagnol and current cell if they are all 1 that forms a square
TC: O(m*n)
Sp: O(n)
"""
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        dp = [0]*(n+1)
        res = 0
        for i in range(m):
            diagUp = 0
            for j in range(1, n+1):
                if matrix[i][j-1]=="1":
                    temp = dp[j]
                    dp[j] = min(dp[j], dp[j-1], diagUp)+1
                    diagUp = temp
                    res = max(res, dp[j])
                else:
                    dp[j] = 0
        return res*res