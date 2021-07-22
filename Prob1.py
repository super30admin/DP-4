class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        maxLen = 0
        m,n = len(matrix),len(matrix[0])
        
        #DP
        #Time complexity: O(mn)
        #Space complexity: O(mn)
        dp = [[0 for x in xrange(n+1)] for x in xrange(m+1)]
        for i in xrange(n):
            dp[1][i+1] = int(matrix[0][i])
        for i in xrange(2,m):
            dp[i+1][1] = int(matrix[i][0])
        
        for i in xrange(1,m+1):
            for j in xrange(1,n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
                    maxLen = max(dp[i][j],maxLen)
                
#         #brute force
#         #Time Complexity: O((mn)^2)
#.        Space complexity: O(1)
#         for i in xrange(m):
#             for j in xrange(n):
#                 flag = False
#                 if matrix[i][j] == '1':
#                     cur = 1
#                     flag = True
#                     while i+cur<m and j+cur<n and flag is not False:
#                         #checking column
#                         for k in xrange(i+cur,i-1,-1):
#                             if k<0:
#                                 break
#                             if matrix[k][j+cur] == '0':
#                                 flag = False
#                                 break
#                         # checking row
#                         for l in xrange(j+cur,j-1,-1):
#                             if l<0:
#                                 break
#                             if matrix[i+cur][l] == '0':
#                                 flag = False
#                                 break
#                         if flag is True:
#                             cur += 1
                            
#                     maxLen = max(cur,maxLen)
        return maxLen*maxLen
