class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        #TC O(mn)
        # SC O(n)
        if matrix is None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxs = 0
        # dp = [[0]*(n+1) for i in range(m+1) ]
        dp =[0]*(n+1)
        prev = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == '1':
                    # MIn between left & up & diagnoal
                    #j already hold old value(up in 2d)
                    temp = dp[j]
                    dp[j]= min(dp[j-1], min((dp[j]),prev))  +1
                    maxs = max(maxs,dp[j])
                    prev = temp
                else:
                    dp[j] = 0
        # print(dp)
        return maxs * maxs
#         #TC O(m*n)^2
#         # SC O(1)
#         if matrix is None or len(matrix) == 0:
#             return 0
#         m = len(matrix)
#         n = len(matrix[0])
#         maxs = 0
#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j] == '1':
#                     cur = 1
#                     valid = True
                    
#                     # if i and j is not out of boundary
#                     while( i + cur < m and j + cur < n):
#                         for k in range(i+ cur, i -1 ,-1):
                            
#                             # Come out of loop, if 0 is found
#                             if (matrix[k][j+cur]=='0'):
#                                 valid = False
#                                 break
#                         if not(valid):
#                             break
#                         for k in range(j+ cur, j -1 ,-1):
                            
#                             # Come out of loop, if 0 is found
#                             if (matrix[i +cur][k]=='0'):
#                                 valid = False
#                                 break
#                         if not(valid):
#                             break
#                         cur += 1
#                     maxs = max(maxs, cur)
#         return maxs * maxs
