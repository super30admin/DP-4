# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Maximal Square

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        mx = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i - 1][j -1], dp[i-1][j], dp[i][j-1])
                    mx = max(mx, dp[i][j])
        return mx * mx