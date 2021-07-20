# Here we are storing the values in dp matrix with minimum of the current element child and getting the maximim length to get the square area
class Solution:
    #     Time Complexity: O(rc)
    #     Space Complexity: O(rc)
    def dp(self, matrix):
        r = len(matrix)
        c = len(matrix[0])

        dp = [[0 for i in range(c)] for j in range(r)]

        maxl = 0

        for i in range(r):
            for j in range(c):
                if matrix[i][j] == '1':
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
                    maxl = max(maxl, dp[i][j])

        return maxl * maxl

    #     Time Compelxity: O(rc)
    #     Space Compelxity: O(c)

    def dpopti(self, matrix):
        r = len(matrix)
        c = len(matrix[0])

        dp = [0 for i in range(c + 1)]

        maxl = 0
        prev = 0

        for i in range(1, r + 1):
            for j in range(1, c + 1):
                if matrix[i - 1][j - 1] == '1':
                    temp = dp[j]
                    dp[j] = min(dp[j - 1], dp[j], prev) + 1
                    prev = temp
                else:
                    dp[j] = 0

                maxl = max(maxl, dp[j])

        return maxl * maxl

    def maximalSquare(self, matrix):
        # return self.dp(matrix)
        return self.dpopti(matrix)

