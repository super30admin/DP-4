class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        row = len(matrix)
        col = len(matrix[0])
        m = 0
        flag = False

        for i in range(row):
            for j in range(col):
                # print(matrix[i][j])
                if matrix[i][j] == "1":
                    curr = 1
                    flag = True

                    while flag and i + curr < row and j + curr < col:
                        for k in range(j, j + curr + 1):
                            if matrix[i + curr][k] == '0':
                                flag = False
                                break

                        for k in range(i, i + curr + 1):
                            if matrix[k][j + curr] == "0":
                                flag = False
                                break

                        if flag:
                            curr += 1
                    # print(curr)
                    m = max(m, curr)

        return m * m

# Brute Solution
# Time Complexity : O(m*n)^2
# Space Complexity: O(1). Not extra space used
# Did this code successfully run on Leetcode : No, gave time limit exceeded
# Any problem you faced while coding this : No
