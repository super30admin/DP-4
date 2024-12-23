# #brute force
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:

        rows = len(matrix)
        cols = len(matrix[0])
        max_side = 0

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == "1":
                    flag = True
                    side_len = 1

                    while flag and i + side_len + 1 < rows and j + side_len + 1 < cols:

                        # check vertical expansion
                        for k in range(i, i + side_len + 1):
                            if matrix[k][j + side_len] == "0":
                                flag = False
                                break

                        for k in range(j, j + side_len + 1):
                            if matrix[i + side_len][k] == "0":
                                flag = False
                                break
                        if flag:
                            side_len += 1

                    max_side = max(max_side, side_len)

        return max_side * max_side


# #time complexity is O(m^2*n^2)
# #space complexity is O(1) as we are just going the input matrix


# dp method
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        max_side = 0
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0] * cols for _ in range(rows)]

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == "1":
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1

                max_side = max(max_side, dp[i][j])
        return max_side * max_side


# time complexity is O(m*n)
# space complexity is O(m*n)
