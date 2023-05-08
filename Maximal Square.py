# Time Complexity :  O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        dp = [[0 for j in range(len(matrix[0])+1)] for i in range(len(matrix)+1)]
        maxsq = 0
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
                    maxsq = max(maxsq, dp[i][j])
        return maxsq*maxsq
