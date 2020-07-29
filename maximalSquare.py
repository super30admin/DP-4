#221. Maximal Square
#Time Complexity is O(mn)  
#Space Complexity is O(mn) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
#class Solution:
#    def maximalSquare(self, matrix: List[List[str]]) -> int:
#        if not matrix or len(matrix[0]) == 0:
#            return 0
#        m = len(matrix)
#        n = len(matrix[0])
#        maxv = 0
#        
#        for i in range(m):
#            for j in range(n):
#                if matrix[i][j] == '1':
#                    curr = 1
#                    flag = True
#                    while i + curr < m and j + curr < n and flag:
#                        cur_row = i + curr
#                        while cur_row >= i:
#                            if matrix[cur_row][j+curr] == '0':
#                                flag = False
#                                break
#                            cur_row-=1
#                        cur_col = j + curr
#                        while cur_col >= j:
#                            if matrix[i+curr][cur_col] == '0':
#                                flag = False
#                                break
#                            cur_col -=1
#
#                        if (flag==True):
#                            curr += 1
#                    maxv = max(maxv,curr)
#        return maxv*maxv

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix[0]) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxv = 0
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
                maxv = max(maxv,dp[i][j])
        return maxv*maxv