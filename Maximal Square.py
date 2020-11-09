# TC: O(N^2)
# SC: O(N^2)
# Yes, It ran on leetcode
# No problems

class Solution:
    def maximalSquare(self, matrix) -> int:
        
        dp = [[0 for i in range(len(matrix[0])+1)] for j in range(len(matrix)+1)]
        Max = 0
        for i in range(1,len(matrix)):
            for j in range(1,len(matrix[0])):
                if matrix[i-1][j-1]=='1':
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1])+1
                    Max = max(Max,dp[i][j])
        return Max*Max