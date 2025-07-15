# Time complexity: O(m x n)
# Space complexity: O(m x n)

def maximalSquare(matrix):
    if not matrix:
        return 0

    m, n = len(matrix), len(matrix[0])
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    max_side = 0

    for i in range(m):
        for j in range(n):
            if matrix[i][j] == '1':
                dp[i + 1][j + 1] = min(dp[i][j], dp[i + 1][j], dp[i][j + 1]) + 1
                max_side = max(max_side, dp[i + 1][j + 1])

    return max_side * max_side
