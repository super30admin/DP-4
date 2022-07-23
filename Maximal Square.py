""""// Time Complexity : O(mn)
// Space Complexity :O(n+1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# DP without mutating matrix
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        ma = 0
        dp = [0 for i in range(n + 1)]
        temp = 0
        temp2 = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                temp = dp[j]
                if matrix[i - 1][j - 1] == '1':
                    dp[j] = min(dp[j], dp[j - 1], temp2) + 1
                else:
                    dp[j] = 0
                temp2 = temp
                ma = max(ma, dp[j])
            print(dp)

        return ma * ma
""""// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# DP without mutating matrix
# class Solution:

#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         m=len(matrix)
#         n=len(matrix[0])
#         ma=0
#         dp=[[0 for i in range(n+1)]for j in range(m+1)]
#         for i in range(1,m+1):
#             for j in range(1,n+1):
#                 if matrix[i-1][j-1]=='1':
#                     dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
#                     ma=max(ma,dp[i][j])
#         return ma*ma

""""// Time Complexity : O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# DP by mutating matrix
# class Solution:
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         m=len(matrix)
#         n=len(matrix[0])
#         if len(matrix) == 0 or matrix == None:
#             return 0
#         maxi=0
#         for j in range(0,n):
#             if matrix[0][j] == "1":
#                 maxi = 1
#         for i in range(0,m):
#             if matrix[i][0] == "1":
#                 maxi = 1
#         for i in range(1, m):
#             for j in range(1, n):
#                 if matrix[i][j]=='1':
#                     top=int(matrix[i-1][j])
#                     # print(top)
#                     topLeft=int(matrix[i-1][j-1])
#                     left=(int(matrix[i][j-1]))
#                     temp=1+min(top, topLeft, left)
#                     maxi=max(maxi, temp)
#                     matrix[i][j]=str(temp)
#         return maxi*maxi

""""// Time Complexity : O((m*n)^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# BruteForce
# class Solution:

#     def maximalSquare(self, matrix: List[List[str]]) -> int:

#         m=len(matrix)
#         n=len(matrix[0])
#         flag=False
#         curr=0
#         ma=0

#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j]=='1':
#                     flag=True
#                     curr=1
#                     # print("x")
#                     # print(i,j)
#                     while(i+curr<m and j+curr<n and flag is True):

#                         # print("m",curr)
#                         for k in range(j,j+curr+1):
#                             if matrix[i+curr][k]=='0':
#                                 flag=False
#                                 break
#                         for k in range(i,i+curr+1):
#                             if matrix[k][j+curr]=='0':
#                                 flag=False
#                                 break
#                         if flag:
#                             curr=curr+1
#                     ma=max(ma,curr)
#                     # print(ma)
#         return ma*ma





