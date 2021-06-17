class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix[0]) == 0: return -1
        row, column = len(matrix), len(matrix[0])
        lengh = 0
        for rowindex in range(row):
            for columnindex in range(column):
                flag = False
                if matrix[rowindex][columnindex] == '1':
                    flag = True
                    currentdiagonal = 1
                    while rowindex + currentdiagonal < row and columnindex + currentdiagonal < column and flag:
                        # column check
                        for c in range(rowindex + currentdiagonal, rowindex - 1, -1):
                            if matrix[c][columnindex + currentdiagonal] == '0':
                                flag = False
                                break
                        # row check
                        for r in range(columnindex + currentdiagonal, columnindex - 1, -1):
                            if matrix[rowindex + currentdiagonal][r] == '0':
                                flag = False
                                break
                        if flag: currentdiagonal += 1

                    lengh = max(lengh, currentdiagonal)
        print(lengh)
        return lengh * lengh

 #tc:- O(mn)2


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix[0]) == 0: return -1

        lengh = 0
        m, n = len(matrix), len(matrix[0])

        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

        for rowindex in range(1, len(dp)):
            for columnindex in range(1, len(dp[0])):

                if matrix[rowindex - 1][columnindex - 1] == '1':
                    dp[rowindex][columnindex] = 1 + min(dp[rowindex][columnindex - 1],
                                                        min(dp[rowindex - 1][columnindex],
                                                            dp[rowindex - 1][columnindex - 1]))
                    lengh = max(lengh, dp[rowindex][columnindex])
        print(lengh)
        return lengh * lengh





#tc:- O(mn)