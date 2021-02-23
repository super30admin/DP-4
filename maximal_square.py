# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# Here for each value in the matrix if value is one then that value is replaced with min of top, left or top left. We store the max whenever we get a new max
# Return the max.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        columns = len(matrix[0])
        maxi = 0
        for i in range(0, rows):
            for j in range(0, columns):
                if matrix[i][j] == "1":
                    matrix[i][j] = 1
                    maxi = 1
                else:
                    matrix[i][j] = 0

                    
        for i in range(1, rows):
            for j in range(1, columns):
                if matrix[i][j] == 1:
                    left = int(matrix[i][j-1])
                    top = int(matrix[i-1][j])
                    top_left = int(matrix[i-1][j-1])
                    matrix[i][j] = min(min(left, top), top_left) + 1
                    if maxi < matrix[i][j]:
                        maxi = matrix[i][j]
                
        return maxi*maxi
