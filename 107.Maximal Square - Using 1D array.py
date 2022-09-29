class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        mx = 0
        dp = [0] * (n + 1)
        prev = 0
        daigUp = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                prev = dp[j]
                if matrix[i - 1][j - 1] == "1":
                    dp[j] = 1 + min(dp[j], min(dp[j - 1], daigUp))
                    mx = max(mx, dp[j])
                else:
                    dp[j] = 0
                daigUp = prev
        return mx * mx


# 1D Array Solution
# Time Complexity : O(m*n)
# Space Complexity: O(n). Size of 1D DP array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
