# # Brute Force Solution
# # Time Complexity: O((mn)^2)
# # Space Complexity : O(1)
# class Solution:
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         m = len(matrix)
#         if m <=0:
#             return 0
#         n = len(matrix[0])
#         maxi = 0
#         flag = False
        
#         for i in range(m):
#             for j in range(n):
                
#                 if matrix[i][j] == '1':
#                     side_len = 1
#                     flag = True
                    
#                     while(side_len+i < m and side_len+j < n and flag):
                        
#                         for r in range(i+side_len,i-1,-1):
#                             if matrix[r][j+side_len] == '0':
#                                 flag = False
#                                 break
#                         for c in range(j+side_len,j-1,-1):
#                             if matrix[i+side_len][c] == '0':
#                                 flag = False
#                                 break
#                         if flag:
#                             side_len += 1
                            
#                     maxi = max(maxi,side_len)
                        
#         return maxi * maxi 

# DP Solution
# Time Complexity: O(mn)
# Space Complexity : O(mn) for the DP array, can do O(1) SC if we change matrix inplaces instead of using DP table
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        if m <=0:
            return 0
        n = len(matrix[0])
        maxi = 0
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=='1':
                    dp[i][j] = min(dp[i-1][j-1],min(dp[i][j-1],dp[i-1][j]))+1
                    maxi = max(maxi,dp[i][j])
                        
        return maxi * maxi 
                        