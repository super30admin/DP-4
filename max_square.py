# Time Complexity : Add - O(m*n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Store maximum square that can be formed by an element in the same or different DP matrix
2. Now the maimum square matrix can be found by min of upper lement, left diagonal, and left element + 1
'''


import sys
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if not matrix or len(matrix) < 1 or len(matrix[0]) < 1:
            return 0
        rows = len(matrix)+1
        cols = len(matrix[0])+1
        
        dp = [[0 for j in range(cols)] for i in range(rows)]
        
        max_ = 0
        
        # dirs = [(-1,0),(0,-1), (-1,-1)]
        for i in range(1,rows):
            for j in range(1,cols):
                
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
                    max_ = max(max_, dp[i][j])
                    
        # print (dp)
                    
        return max_*max_
                
                    
        