# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The largest square with all 1s is found by taking the minimum of the three adjacent cells and adding 1 to it. 
This is done starting from the last cell and then building up to cell 0,0. 
"""

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        M = matrix
        m, n, ans = len(M), len(M[0]), 0
        dp = [[0]*(n+1) for i in range(m+1)]
        
        for i, j in product(range(m-1, -1, -1), range(n-1, -1, -1)):
            dp[i][j] = 1 + min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1]) if M[i][j] == '1' else 0
            ans = max(ans, dp[i][j])
        return ans * ans