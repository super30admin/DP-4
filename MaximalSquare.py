"""
Time Complexity : O(m x n) where m and n are the length of the matrix
Space Complexity : O(m x n) where m and n are the length of the matrix
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0]*(n+1) for i in range(m+1)]
        maxi = 0
        """
        We move through the matrix and whenever we encounter 1 we look diagonally
        above the current, left and just above and calculate the minimum among those           and set it as current by incrementing it to 1 and updating the max count.
        Ultimately we return the dimension as max*max
        """
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j -1]) + 1
                    maxi = max(dp[i][j], maxi)
        return maxi*maxi