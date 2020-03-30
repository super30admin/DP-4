'''
Time Complexity: O((mn^2)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Iterate through the matrix from the diagonals (bottom and right) and keep checking if it is a square, if
even once you see a '0', end the current search. contiue until u see a 0 or reach the end and save the largest square
size on the way.
'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        rows = len(matrix)
        col = len(matrix[0])
        maxSqlen = 0
        for i in range(0, rows):
            for j in range(0, col):
                if matrix[i][j] == '1':
                    sqlen = 1
                    flag = True

                    while sqlen + i < rows and sqlen + j < col and flag:
                        for k in range(j, sqlen + j + 1):
                            if matrix[i + sqlen][k] == '0':
                                flag = False
                                break
                        for k in range(i, sqlen + i + 1):
                            if matrix[k][j + sqlen] == '0':
                                flag = False
                                break
                        if flag:
                            sqlen += 1
                    maxSqlen = max(maxSqlen, sqlen)

        return maxSqlen * maxSqlen
