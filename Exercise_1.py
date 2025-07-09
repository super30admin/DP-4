# S30 Problem #109 Maximal Square
#LeetCode #221. https://leetcode.com/problems/maximal-square/description/
# Author : Akaash Trivedi
# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# brute force solution
# For each 1, this is pivot, and try to expand square diagonally by increasing one level
# at each new level, check all the element above (right most column) and all elements to left (bottom most row) ensure all elements are 1
#check for each pivot. keep track of maximum level diagonal and return square of max level
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxa = 0 # maximum area
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    level = 1
                    flag = True # reset for each potential square
                    while i + level < m and j + level < n and flag:
                        # check the right most column at this level
                        for r in range(i,i + level+ 1):
                            if matrix[r][j+level] == '0':  
                                flag = False # early stop if we find 0, no need to check rest
                                break
                        # check the bottom most column at this level
                        for c in range(j, j + level + 1):
                            if matrix[i+level][c] == '0':
                                flag = False
                                break
                        if flag:
                            level += 1
                        else:
                            break
                    maxa = max(level,maxa)
        return maxa * maxa
    
# dp solution
# Bottom up approach. For each 1, starting at right most row and col and move upwards and leftward. calculate the max size of square dp[i][j], by neighboring cells (right, bottom and diagonal) 
# For 1, size of square at i,j is the min of neighboring squares (right, bottom and diagonal) and adding one to it
# track max square size dp found during traversal and return its square

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        if m==0:
            return 0
        n = len(matrix[0])
        # taking extra dummy row and column
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        maxa = 0 # maximum area
        # loop from bottom up, last row, last column element
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if matrix[i][j] == '1':
                    # min of right, bottom, diagonal
                    dp[i][j] = min(dp[i][j+1], dp[i+1][j], dp[i+1][j+1]) + 1
                    maxa = max(maxa, dp[i][j])
        return maxa * maxa