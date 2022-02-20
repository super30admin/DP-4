#Time And Space Complexity O(m*n)

from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:

        if len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        maxv = 0

        dp = [0] * (n+1)
        diagUp = 0
        temp = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                temp = dp[j]
                if(matrix[i-1][j-1] == '1'):
                    dp[j] = 1 + min(dp[j-1], min(dp[j], diagUp))
                    maxv = max(maxv, dp[j])
                else:
                    dp[j] = 0


                diagUp = temp

        return maxv * maxv
