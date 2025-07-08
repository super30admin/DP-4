from typing import List
# class Solution:
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         m, n = len(matrix), len(matrix[0])
#         maxArea = 0
#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j] == "1":
#                     # square starts
#                     l=1
#                     flag = True
#                     while i+l<m and j+l<n and flag:
#                         for r in range(i+l,i-1,-1):
#                             if matrix[r][j+l] == '0':
#                                 flag = False
#                                 break
#                         for c in range(j+l, j-1, -1):
#                             if matrix[i+l][c] == '0':
#                                 flag = False
#                                 break
#                         if flag: l+=1
#                     maxArea = max(maxArea, l)
#         return maxArea * maxArea

# class Solution:
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         m, n = len(matrix), len(matrix[0])
#         maxArea = 0
#         dp = [[0 for j in range(n+1)]  for i in range(m+1)]
#         for i in range(m-1, -1, -1):
#             for j in range(n-1, -1, -1):
#                 if matrix[i][j] == '1':
#                     dp[i][j] = 1+min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])
#                     maxArea = max(maxArea,dp[i][j])
#         return maxArea * maxArea
                            
                            

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        maxArea = 0
        dp = [0]*(n+1)
        for i in range(m-1, -1, -1):
            diagdown = 0
            for j in range(n-1, -1, -1):
                temp = dp[j]
                if matrix[i][j] == '1':
                    dp[j] = 1+min(dp[j], dp[j+1], diagdown)
                    maxArea = max(maxArea,dp[j])
                else:
                    dp[j] = 0
                diagdown = temp
        return maxArea * maxArea
                            
                            


        
                            
                            


        