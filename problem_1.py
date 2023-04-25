# Brute Force
# Time Complexity - O(m*n)
# Space Complexity - O(m*n)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxVal = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    maxVal = max(maxVal, 1) 
                    k = 1
                    flag = True
                    while j+k < n and i+k < m and flag:
                        for r in range(j, j+k+1):
                            if matrix[i+k][r] == '0':
                                flag = False
                                break
                        for c in range(i, i+k+1):
                            if matrix[c][j+k] == '0':
                                flag = False
                                break
                        if flag:
                            k += 1
                            maxVal = max(maxVal, k)
                        else:
                            break
        return maxVal * maxVal

# DP
# Time Complexity - O(m*n)
# Space Complexity - O(m*n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        maxVal = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == '1':
                   
                    dp[i][j] = 1+ min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
                    maxVal = max(maxVal,dp[i][j])
        return maxVal * maxVal