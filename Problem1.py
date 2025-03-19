# Problem 1 : Maximal Square
# Time Complexity : 
'''
Top-Down: O(m*n) where m is the number of rows and n is the number of column
Bottom-up 2d matrix: O(m*n) where m is the number of rows and n is the number of column
Bottom-up 1d dp array: O(m*n) where m is the number of rows and n is the number of column
'''
# Space Complexity : 
'''
Top-Down: O(m*n) where m is the number of rows and n is the number of column
Bottom-up 2d matrix: O(m*n) where m is the number of rows and n is the number of column
Bottom-up 1d dp array: O(n) where n is the number of column
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# top-down approach
from typing import List
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # get the length of the row of the matrix
        rowLength = len(matrix)
        # if the length of the row is 0 then return 0
        if rowLength == 0: return 0

        # get the length of the column of matrix
        colLength = len(matrix[0])
        # define dp matrix with rowLength+1 and colLength+1 and filled with 0
        dpMatrix = [[0] * (colLength+1) for _ in range(rowLength+1)]
        # initialize the variable for maxArea with 0
        maxArea = 0

        # for loop from 1 to rowLength+1
        for i in range(1,rowLength+1):
            # for loop from 1 to colLength+1
            for j in range(1, colLength+1):
                # check if the cell at (i-1)(j-1) position in matrix is 1
                if matrix[i-1][j-1] == '1':
                    # the value for dp matrix at i and j position is minimum of value at (i)(j-1), (i-1)(j) and (i-1)(j-1) position + 1
                    dpMatrix[i][j] = min(min(dpMatrix[i][j-1], dpMatrix[i-1][j]), dpMatrix[i-1][j-1]) + 1
                    # the max area by getting the maximum value between maxArea and current dp value at i and j position
                    maxArea = max(maxArea, dpMatrix[i][j])
        # return maxArea*maxArea
        return maxArea * maxArea


# bottom-up approach using dp matrix
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # get the length of the row of the matrix
        rowLength = len(matrix)
        # if the length of the row is 0 then return 0
        if rowLength == 0: return 0

        # get the length of the column of matrix
        colLength = len(matrix[0])

        # define dp matrix with rowLength+1 and colLength+1 and filled with 0
        dpMatrix = [[0] * (colLength+1) for _ in range(rowLength+1)]
        # initialize the variable for maxArea with 0
        maxArea = 0

        # for loop from rowLength-1 to -1
        for i in range(rowLength-1, -1, -1):
            # for loop from colLength-1 to -1
            for j in range(colLength-1, -1, -1):
                # check if the cell at (i-1)(j-1) position in matrix is 1
                if matrix[i][j] == '1':
                    # the value for dp matrix at i and j position is minimum of value at (i)(j+1), (i+1)(j) and (i+1)(j+1) position + 1
                    dpMatrix[i][j] = min(min(dpMatrix[i][j+1], dpMatrix[i+1][j]), dpMatrix[i+1][j+1]) + 1
                    # the max area by getting the maximum value between maxArea and current dp value at i and j position
                    maxArea = max(maxArea, dpMatrix[i][j])
        
        # return maxArea*maxArea
        return maxArea * maxArea


# bottom-up approach using 1 d array
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # get the length of the row of the matrix
        rowLength = len(matrix)
        # if the length of the row is 0 then return 0
        if rowLength == 0: return 0

        # get the length of the column of matrix
        colLength = len(matrix[0])

        # define dp array with colLength+1 and filled with 0
        dp = [0] * (colLength + 1)
        # initialize the variable for maxArea with 0
        maxArea = 0

        # for loop from rowLength-1 to -1
        for i in range(rowLength-1, -1, -1):
            # initialize temprorary diagonalDown variable to 0
            diagonalDown = 0
            # for loop from colLength-1 to -1
            for j in range(colLength-1, -1, -1):
                # store the value of dpMatrix[j] in temp before overwriting the dpMatrix[j] value
                temp = dp[j]
                # check if the cell at (i-1)(j-1) position in matrix is 1
                if matrix[i][j] == '1':
                    # the value for dp[j] is minimum of value at jth and (j+1)th position and diagonalDown + 1
                    dp[j] = min(min(dp[j], dp[j+1]), diagonalDown) + 1
                    # the max area by getting the maximum value between maxArea and current dp value at j position
                    maxArea = max(maxArea, dp[j])
                else:
                    # else set the value of dp[j] 0 
                    dp[j] = 0
                # set the value of diagonalDown with temp
                diagonalDown = temp
        
        # return maxArea*maxArea
        return maxArea * maxArea
