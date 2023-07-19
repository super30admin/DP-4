# Time Complexity :O(n)
# Space Complexity :O(n)
# Leet Code: Yes

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:

        c = len(matrix[0])
        r = len(matrix)
        maxL = 0

        dp = [[0 for _ in range(c+1)] for _ in range(r+1)]
        

        for i in range(1, r+1):
            for j in range(1, c+1):
                if matrix[i-1][j-1] == '1':

                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
                    maxL = max(maxL, dp[i][j])

        return maxL*maxL