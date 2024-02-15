'''

Time Complexity : O(mn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Using a cache we go on calculating the maximum possible square that can be formed by traversing the matrix. This depends on whether the element
in the matrix is '1' or '0'

'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        maxx = 0
        ref = [[0] * len(matrix[0]) for _ in range(len(matrix))]

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):

                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        ref[i][j] = 1
                    else:
                        ref[i][j] = min(ref[i-1][j],ref[i-1][j-1],ref[i][j-1]) + 1

                maxx = max(maxx, ref[i][j])

        return maxx ** 2