#Time Complexity : O(m*n) where m and n are number of rows and columns in the given matrix
#Space Complexity : O(m*n) where m and n are number of rows and columns in the given matrix
#Did this code successfully run on Leetcode : Yes

class Solution:
    #DP
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        maxArea = 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    maxArea = max(maxArea, dp[i][j])

        return maxArea*maxArea

    #BRUTE FORCE - TC -> O((mn)^2) SC -> O(1)
    # def maximalSquare(self, matrix: List[List[str]]) -> int:
    #     if not matrix:
    #         return 0
    #     m, n = len(matrix), len(matrix[0])
    #     maxArea = 0
    #     flag = False
    #     for i in range(m):
    #         for j in range(n):
    #             if matrix[i][j] == '1':
    #                 flag = True
    #                 diag = 1
    #                 while (i+diag < m) and (j+diag < n) and flag:
    #                     #check all columns up that diagnol
    #                     for k in range(i, i+diag+1):
    #                         if matrix[k][j+diag] == '0':
    #                             flag = False
    #                             break
    #
    #                     if flag == False:
    #                         break
    #
    #                     #check all rows upto that diagnol
    #                     for k in range(j, j+diag+1):
    #                         if matrix[i+diag][k] == '0':
    #                             flag = False
    #                             break
    #
    #                     if flag:
    #                         diag += 1
    #
    #                 maxArea = max(maxArea, diag)
    #
    #     return maxArea*maxArea
