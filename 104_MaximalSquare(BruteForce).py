# Accepted on leetcode(221)
# time - O(m^2*n^2)
# space - O(1)
# Move diagonally and always check for if all the neighbouring elements are 1 in the column and row.

class Solution:
    def maximalSquare(self, matrix) -> int:
        rows = len(matrix)

        # edge case
        if rows == 0: return 0

        cols = len(matrix[0])
        maximum = 0
        flag = False
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    flag = True
                    curr = 1
                    # ith and jth location of my window diagonal
                    while i + curr < rows and j + curr < cols and flag:
                        # the column j + curr
                        for k in range(i + curr, i - 1, -1):
                            if matrix[k][j + curr] == '0':
                                flag = False
                                break;
                        # the row i + curr
                        for k in range(j + curr, j - 1, -1):
                            if matrix[i + curr][k] == '0':
                                flag = False
                                break;
                        if flag: curr += 1
                    maximum = max(maximum, curr)
        return maximum * maximum