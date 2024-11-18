#Approach
#Start from the each cell and find the min(right and down) add +1 to it and store the result and return 0,0


#Complexities
#Time : O(m*n)
#Space: O(m*N)



from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        max_len = 0

        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
                    max_len = max(max_len, dp[i][j])

        return max_len * max_len


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        max_len = 0
        prev = [0 for _ in range(n)]

        for i in range(m):
            curr = [0 for _ in range(n)]

            for j in range(n):
                if matrix[i][j] == "1":
                    curr[j] = min(prev[j - 1], curr[j - 1], prev[j]) + 1
                    max_len = max(max_len, curr[j])
            prev = curr

        return max_len * max_len
s = Solution()
s.maximalSquare([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]])