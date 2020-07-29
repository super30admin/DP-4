"""
// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this : no
"""

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        r = len(matrix)
        c = len(matrix[0])
        
        dp = [[0 for i in range(c + 1)]for j in range(r + 1)]
        #print(dp)
        m = 0
        for i in range(1,r + 1):
            for j in range(1,c + 1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) #stores one dimension of the maximum square that can be formed at that point
                    m = max(m, dp[i][j]) #maximum dimension
        return m*m 