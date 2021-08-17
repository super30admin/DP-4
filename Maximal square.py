class Solution:
    def maximalSquare(self, matrix) :
        if matrix == None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maximum = 0
        dp = [[0 for i in range(n + 1)] for i in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i][j - 1], min(dp[i - 1][j], dp[i - 1][j - 1])) + 1
                    maximum = max(maximum, dp[i][j])

        return maximum * maximum

class Solution:
    def maximalSquare(self, matrix) :
        if matrix == None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maximum = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    flag = True
                    curr = 1
                    while i+curr < m and j+curr < n and flag:
                        for k in range(i+curr,i-1,-1):
                            if matrix[k][j+curr] == '0':
                                flag = False
                                break
                        for k in range(j+curr,j-1,-1):
                            if matrix[i+curr][k] == '0':
                                flag = False
                                break
                        if flag:
                            curr += 1
                    maximum = max(maximum, curr)
        return maximum * maximum