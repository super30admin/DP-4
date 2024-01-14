"""
Time Complexity : O(m*n) where m is the number of rows and n is the number of cols of the matrix
Space Complexity :  O(m*n) where m is the number of rows and n is the number of cols of the matrix. This space is used for dp matrix

Did this code successfully run on Leetcode : No, Time Limit Exceeded
Any problem you faced while coding this : No
"""


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        ans = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
                    ans = max(ans, dp[i][j])

        return ans*ans
