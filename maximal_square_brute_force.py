"""
Time Complexity : O(m*n)(m*n) where m is the number of rows and n is the number of cols of the matrix
Space Complexity :  O(1) as we are not using any Auxillary Data Structure

Did this code successfully run on Leetcode : No, Time Limit Exceeded
Any problem you faced while coding this : No

Logic:
for every '1', check its diagonal elements 
    if it is also 1 then check if all the elements in the same colum till original column are 1 if yes do the same for all the elements in row, if yes increase level and repeat until the last element in matrix
    otherwise record the level and go to next '1'
"""


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        ans = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    level = 1
                    flag = True
                    while i+level < m and j+level < n and flag:
                        if matrix[i+level][j+level] == '0':
                            flag = False
                            break

                        # rows
                        for k in range(j+level, j-1, -1):
                            if matrix[i+level][k] == '0':
                                flag = False
                                break

                        # Columns
                        for k in range(i+level, i-1, -1):
                            if matrix[k][j+level] == '0':
                                flag = False
                                break

                        if flag:
                            level += 1
                    ans = max(level, ans)

        return ans * ans
