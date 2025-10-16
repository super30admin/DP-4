# Time Complexity : O(N*M) where N * M is the size of the matrix
# Space Complexity : O(1) as we are modifying the input matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using dynamic programming to solve this problem.
# I am iterating through the matrix from bottom right to top left.
# I am doing this in place to save space. I am modifying the input matrix to store the size of the square.
# I am checking if the current cell is 1, if it is then I am checking the minimum of the right, bottom and bottom right cells and adding 1 to it.
# I am also keeping track of the maximum size of the square found so far.
# This makes sure that we are only considering squares that can be formed with the current cell as the top left corner.
# Finally, I am returning the area of the maximum square found.

from typing import List
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxy = 0
        # dp = [[0] *(n+1) for _ in range(m+1)]
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if matrix[i][j] == "1":
                    if i == m-1 or j == n-1:
                        matrix[i][j] = 1
                    else:
                        matrix[i][j] = 1 + min(int(matrix[i][j+1]),min(int(matrix[i+1][j]),int(matrix[i+1][j+1])))
                    maxy = max(maxy,matrix[i][j])
        return maxy*maxy
                        

                