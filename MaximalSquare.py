------------------------Maximal Square--------------------------------------------

# Time Complexity : O(MXN) M is the number of rows and N is the number of columns
# Space Complexity : O(MXN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I will initialize the dp array and first row and col should be zero. from next indices we will check if matrix 
#contains 0, If it is 0 we know there is no square, but if we have 1 we will check the surrounding indexes, 
# and check min among them and add one to it. If we have a square in the previous rows , we will have counted that square in the previous rows itself. 

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])
        
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        res = 0
        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if i == 0 or j == 0:
                    dp[i][j] = 0
                elif int(matrix[i-1][j-1]) == 0:
                    dp[i][j] = 0
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
            
                res = max(res, dp[i][j])
        return res**2