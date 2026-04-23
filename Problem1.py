# https://leetcode.com/problems/maximal-square/description/

# Bruteforce solution
# TC: O(m^2 n^2)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        maxi = 0

        for i in range(0, m):
            for j in range(0, n):

                if matrix[i][j] == "1":
                    le = 1
                    flag = True

                    while i+le < m and j+le < n:
                        for k in range(i+le, i-1, -1):
                            if matrix[k][j+le] == "0":
                                flag = False
                                break

                        for k in range(j+le, j-1, -1):
                            if matrix[i+le][k] == "0":
                                flag = False
                                break

                        if flag:
                            le += 1
                        else:
                            break

                    maxi = max(maxi, le)

        return maxi*maxi

# DP with tabulation. Top-down approach

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dp = [[0] * (n+1) for _ in range(m+1)]

        maxi = 0

        # top to bottom
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = 1 + min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1]))
                    maxi = max(maxi, dp[i][j])
        return maxi * maxi
    
# DP with tabulation. Bottom-up approach

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dp = [[0] * (n+1) for _ in range(m+1)]

        maxi = 0

        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if matrix[i][j] == "1":
                    dp[i][j] = 1 + min(dp[i+1][j], min(dp[i][j+1], dp[i+1][j+1]))
                    maxi = max(maxi, dp[i][j])
        return maxi * maxi

# DP with 1D array

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dp = [0] * (n+1)
        maxi = 0
        diagUp = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == "1":
                    temp = dp[j]
                    dp[j] = 1 + min(dp[j], min(dp[j-1], diagUp))
                    diagUp = temp
                    maxi = max(maxi, dp[j])
                else:
                    dp[j] = 0
        return maxi * maxi

