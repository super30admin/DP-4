

#Brute Force
#Time Complexity: O((MN)^2)
#Space Complexity: O(1)
def maximalSquare(self, matrix: List[List[str]]) -> int:
    m = len(matrix)
    n = len(matrix[0])

    if not matrix:
        return 0
    result = 0
    for i in range(m):
        for j in range(n):
            if matrix[i][j] == "1":
                l = 1
                flag = True
                while (i + l < m and j + l < n and flag):
                    # check all are ones
                    for x in range(i + l, i - 1, -1):
                        if matrix[x][j + l] == "0":
                            flag = False
                            break
                    for y in range(j + l, j - 1, -1):
                        if matrix[i + l][y] == "0":
                            flag = False
                            break
                    if flag:
                        l += 1
                result = max(result, l)
    return result * result

#Time Complexity: O(MN)
#Space Complexity: O(MN)

def maximalSquarewithDpMatrix(self, matrix: List[List[str]]) -> int:
    m = len(matrix)
    n = len(matrix[0])

    if not matrix:
        return 0
    dp = [[0] * (n + 1) for i in range(m + 1)]
    result = 0
    for i in range(m):
        for j in range(n):
            if matrix[i][j] == "1":
                dp[i + 1][j + 1] = min(dp[i][j + 1], dp[i + 1][j], dp[i][j]) + 1
                result = max(result, dp[i + 1][j + 1])

    # print(dp)
    return result * result

#Time Complexity: O(MN)
#Space Complexity: O(1)
def maximalSquare(self, matrix: List[List[str]]) -> int:
    m = len(matrix)
    n = len(matrix[0])

    if not matrix:
        return 0
    # dp = [[0]*(n+1) for i in range(m+1)]
    result = 0
    for i in range(m):
        if matrix[i][0] == "1":
            result = 1
    for i in range(n):
        if matrix[0][i] == "1":
            result = 1

    for i in range(1, m):
        for j in range(1, n):
            if matrix[i][j] == "1":
                temp = min(int(matrix[i - 1][j]), int(matrix[i][j - 1]), int(matrix[i - 1][j - 1])) + 1
                result = max(result, temp)
                matrix[i][j] = str(temp)

    # print(dp)
    return result * result
