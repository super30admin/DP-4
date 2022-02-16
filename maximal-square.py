#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
class Solution(object):
    result = 0
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        #DP Optimized
        maxx = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [0 for i in range(n)]
        for j in range(n):
            dp[j] = matrix[0][j]
        diagonalUp = 0
        for i in range(1, m):
            for j in range(0, n):
                temp = dp[j]
                if matrix[i][j] == "1":
                    if j == 0:
                        dp[0] = matrix[i][0]
                    else:
                        dp[i] = min(diagonalUp, min(dp[i-1], dp[i]))
                    diagonalUp = temp
                    maxx = max(maxx, dp[i])
        return maxx*maxx
        #DP
        # maxx = 0
        # m = len(matrix)
        # n = len(matrix[0])
        # dp = [[0 for i in range(n+1)] for j in range(m+1)]
        # for i in range(1, len(dp)):
        #     for j in range(1, len(dp[0])):
        #         if matrix[i-1][j-1] == '1':
        #             dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1
        #             maxx = max(maxx, dp[i][j])
        # return maxx*maxx
        
        #Time Limit Exceeded
#         def checkSum(x1, y1, x2, y2):
#             if x1 < len(matrix) and x2 < len(matrix) and y1 < len(matrix[0]) and y2 < len(matrix[0]):
#                 actualSum = (x2-x1+1)*(y2-y1+1)
#                 summ = 0
#                 for i in range(x1, x2+1):
#                     for j in range(y1, y2+1):
#                         summ += int(matrix[i][j])
#                 return summ == actualSum
#             return False
        
#         def helper(i, j):
#             if matrix[i][j] == "1":
#                 self.result = max(1, self.result)
#                 x, y = i,j
#                 while checkSum(i, j, x, y):
#                     temp = (x-i+1)*(y-j+1)
#                     x += 1
#                     y += 1
#                     print(temp)
#                     self.result = max(self.result, temp)

#         for i in range(len(matrix)):
#             for j in range(len(matrix[0])):
#                 helper(i, j)
#         return self.result