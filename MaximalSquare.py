"""
Rasika Sasturkar
Time complexity: Brute force - O((m*n)^2), DP - O(m*n)
Space complexity: O(1) - mutating the same array
"""


def maximalSquare(matrix) -> int:
    # null case
    if matrix is None:
        return 0

    m = len(matrix)
    n = len(matrix[0])

    max_sq = 0

    # Brute force
    # flag = False  # when we hit a square
    # for i in range(m):
    #     for j in range(n):
    #         if matrix[i][j] == '1':
    #             flag = True
    #             k = 1  # side
    #             while i + k < m and j + k < n and flag:
    #                 for r in range(i + k, i - 1, -1):
    #                     if matrix[r][j + k] == '0':
    #                         flag = False
    #                         break
    #                 for c in range(j + k, j - 1, -1):
    #                     if matrix[i + k][c] == '0':
    #                         flag = False
    #                         break
    #                 if flag:
    #                     k += 1
    #             max_sq = max(max_sq, k)

    # Using an extra array
    # dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    # for i in range(1, m + 1):
    #     for j in range(1, n + 1):
    #         if matrix[i - 1][j - 1] == '1':
    #             dp[i][j] = 1 + min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1])
    #             max_sq = max(max_sq, dp[i][j])

    # Populating the same array
    for i in range(m):
        if matrix[i][0] == '1':
            max_sq = 1
    for j in range(n):
        if matrix[0][j] == '1':
            max_sq = 1
    for i in range(1, m):
        for j in range(1, n):
            if matrix[i][j] == '1':
                left = int(matrix[i - 1][j])
                up = int(matrix[i][j - 1])
                diag = int(matrix[i - 1][j - 1])
                matrix[i][j] = 1 + min(up, left, diag)
                max_sq = max(max_sq, matrix[i][j])
    return max_sq * max_sq


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(maximalSquare(matrix=[["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"]
        , ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]))  # returns 4
    print(maximalSquare(matrix=[["0", "1"], ["1", "0"]]))  # returns 1
    print(maximalSquare(matrix=[["0"]]))  # returns 0


if __name__ == "__main__":
    main()
