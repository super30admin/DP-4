"""
Time Complexity : O(mn) 
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def maximalSquare(self, matrix):
        rows = len(matrix)
        if not matrix or rows == 0:
            return 0
        cols = len(matrix[0])
        dp = [[0]*(cols+1) for i in range(rows+1)]
        max_area = 0
        print(dp)
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                max_area = max(max_area, dp[i][j])
        
        return max_area**2
    
    
s = Solution()
print(s.maximalSquare([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]))
        
        