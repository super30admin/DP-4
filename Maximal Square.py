# time complexity is o(mn), where m,n is the number of rows and columns in the matrix
# space complexity is o(n), where n is the number of columns in the matrix
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxi = 0
        for i in range(n):
            if(matrix[0][i] == '1'):
                maxi = 1
        for i in range(m):
            if(matrix[i][0] == '1'):
                maxi = 1
        dp = [0 for i in range(n+1)] #space is o(n), n is number of columns in matrix
        for i in range(1, m+1):
            diagup = 0
            for j in range(1, n+1):
                temp = dp[j]
                if(matrix[i-1][j-1] == '1'):
                    dp[j] = 1 + min(diagup, dp[j], dp[j-1])
                    maxi = max(maxi, dp[j])
                else:
                    dp[j] = 0
                diagup = temp
        return maxi*maxi
        
        
        
#         m = len(matrix)
#         n = len(matrix[0])
#         maxi = 0
#         for i in range(n):
#             if(matrix[0][i] == '1'):
#                 maxi = 1
#         for i in range(m):
#             if(matrix[i][0] == '1'):
#                 maxi = 1
#         dp = [[0 for i in range(n+1)] for j in range(m+1)]
#         # print(dp)
#         for i in range(1, m+1):
#             for j in range(1, n+1):
#                 # print(i,j)
#                 if(matrix[i-1][j-1] == '1'):
#                     dp[i][j] = 1 + min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1])
#                     maxi = max(maxi, dp[i][j])
#                     # print(maxi)
#         return maxi*maxi
        
        
        
#        time o(n^2)
#        space o(1)
        # m = len(matrix)
        # n = len(matrix[0])
        # maxi = 0
        # for i in range(n):
        #     if(matrix[0][i] == '1'):
        #         maxi = 1
        # for i in range(m):
        #     if(matrix[i][0] == '1'):
        #         maxi = 1
        # for i in range(1, m):
        #     for j in range(1, n):
        #         if(matrix[i][j] == '1'):
        #             left = int(matrix[i][j-1])
        #             top = int(matrix[i-1][j])
        #             topleft = int(matrix[i-1][j-1])
        #             matrix[i][j] = 1 + min(left, top, topleft)
        #             maxi = max(maxi, matrix[i][j])
        # return maxi*maxi
                    
                
        