"""
Problem1:(https://leetcode.com/problems/maximal-square/)

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 


1 0 1 0 0

1 0 1 1 1

1 1 1 1 1

1 0 0 1 0

Output: 4
"""

# Approach - 1
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        I this we will iterate through each row and col till we meet a "1" 
        and then we will again iterate from its downwards diag to upwards (Ceiling) and left(walls).
        Time Complexity: O(m * n)^2
        space complexity: O(1)
        """
        if matrix == None or len(matrix) == 0: return 0
        row_len = len(matrix)
        col_len = len(matrix[0])
        
        # Record that we have hit a square
        flag = False
        square = 0
        
        # iterate through the matrix
        for r in range(0,row_len):
            for c in range(0,col_len):
                if matrix[r][c] == "1":
                
                    flag = True
                    k = 1
                    while (r + k < row_len and c + k < col_len and flag):
                        # checking in the same col (ceiling)
                        for i in range((r+k) , (r - 1), -1):
                            
                            if matrix[i][c + k] == "0":
                                flag = False
                                break
                                
                        # checking the same row (wall)
                        for i in range(c + k, c - 1, -1):
                            
                            if matrix[r + k][i] == "0":
                                flag = False
                                break
                                
                        if flag:
                            k += 1
                       
                    square = max(square, k)
                
                
        return square * square
        

# Approach - 2

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        Using bottom up DP and taking the upward diag, upward and left cells
        Time Complexity: O(m*n)
        space Complexity: O(m*n)
        """
        if matrix == None or len(matrix) == 0: return 0
        row_len = len(matrix)
        col_len = len(matrix[0])
        
        dp = [[0 for _ in range(col_len + 1 )] for _ in range(row_len + 1) ]
        max_sq = 0
        
        for i in range(1, row_len + 1):
            for j in range(1, col_len + 1):
                if matrix[i -1][j -1] == "1":
                    dp[i][j] = 1 + int(min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])))
                    max_sq = max(max_sq, dp[i][j])
                    
        return max_sq*max_sq
        

# Approach - 3

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        Using the same approach as above with a constant space.
        """
        if matrix == None or len(matrix) == 0: return 0
        
        row_len = len(matrix)
        col_len = len(matrix[0])
        max_sq = 0
        
        # check for top row
        for i in range(col_len):
            if matrix[0][i] == "1": max_sq = 1
                
        # check for left most col
        for i in range(row_len):
            if matrix[i][0] == "1": max_sq = 1
            
            
        for i in range(1, row_len):
            for j in range(1, col_len):
                if matrix[i][j] == "1":
                    diag = int(matrix[i - 1][j -1])
                    left = int(matrix[i][j -1])
                    up   = int(matrix[i - 1][j])
                    sq = 1 + min(diag, min(left, up))
                    
                    max_sq = max(max_sq, sq)
                    matrix[i][j] = str(sq)
                    
       
                    
        return (max_sq*max_sq)
        