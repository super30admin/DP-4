# Time Complexity : O(m*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])

        maxval = 0
        prev = 0
        diagonal = 0

        # initially array is all 0's
        dp = [0]*(n + 1)

        for i in range(1, m + 1):

            for j in range(1, n + 1):

                prev = dp[j]
                # if value is equal to 1
                if matrix[i-1][j-1] == '1':
                    # keep updating the value
                    dp[j] = 1 + min(dp[j-1], min(dp[j], diagonal))
                    maxval = max(maxval, dp[j])

                else:
                    dp[j] = 0

                diagonal = prev

        return maxval * maxval
