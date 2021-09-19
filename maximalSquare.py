"""
//Time Complexity : O(M*N)
// Space Complexity :O(M*N) with  queue withourt queue o(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        #T.C = o(m*n)
        #S.C = O(m*n)
        if matrix==None or len(matrix)==0:
            return 0
        m = len(matrix)
        n= len(matrix[0])
        dp = [[0 for j in range(0,n+1)] for i in range(0,m+1)]
        print(dp)
        max1 = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if(matrix[i-1][j-1]=="1"):
                    dp[i][j] = min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]) + 1
                    max1 = max(max1,dp[i][j])
        return max1*max1
                    
#         #T.C = 0(m*n)^2
#         #S.C = 0(1)
#         m = len(matrix)
#         if (m== 0 or matrix == None):
#             return 0
#         n = len(matrix[0])
#         max1 = 0

#         for i in range(0,m):
#             for j in range(0,n):
#                 if(matrix[i][j]=='1'):
#                     curr = 1
#                     valid = True
#                     while(i+curr<m and j+curr<n):
#                         #moving upwards
#                         k= i+curr
#                         while(k>=i):
#                             if matrix[k][j+curr] == "0":
#                                 valid = False
#                                 break
#                             k-=1
#                         if(not valid):
#                             break
#                         k = j + curr
#                         while(k>=j):
#                             if matrix[i+curr][k]=="0":
#                                 valid = False
#                                 break
#                             k-=1
#                         if(not valid ):
#                             break
#                         curr+=1
#                     max1 = max(max1,curr)
#         return max1*max1
                            
                            
        
