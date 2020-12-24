"""
Time Complexity : O(mn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
To calculate the length of a square, we need to start from 1,1 position, see element above, on left and on left
diagonal, take the minimum and add one. We keep on doing this whenever we find 1 and maintain the
maximum value obtained so far. return square of maxx value at the end to fetch the area.
"""


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxx = 0
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == "1":
                    matrix[i][j] = min(
                        int(matrix[i-1][j-1]), int(matrix[i-1][j]), int(matrix[i][j-1]))+1
                    maxx = max(maxx, matrix[i][j])
        if maxx == 0:
            for i in matrix:
                if "1" in i:
                    return 1
        return maxx*maxx
