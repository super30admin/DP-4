"""
Time Complexity : O(m*n) where m is the number of rows and n is the number of cols of the matrix
Space Complexity :  O(1) as we are not using any Auxillary Data Structure

Did this code successfully run on Leetcode : No, Time Limit Exceeded
Any problem you faced while coding this : No
"""


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        ans = 0

        for j in range(0, n):
            if matrix[0][j] == '1':
                ans = 1

        for i in range(0, m):
            if matrix[i][n-1] == '1':
                ans = 1

        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                if matrix[i][j] == '1':
                    right = int(matrix[i][j+1])
                    down = int(matrix[i+1][j])
                    dig = int(matrix[i+1][j+1])

                    matrix[i][j] = min(right, down, dig) + 1
                    ans = max(ans, matrix[i][j])
                    print(ans)
                    matrix[i][j] = str(matrix[i][j])

        return ans * ans
