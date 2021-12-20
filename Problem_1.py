# Brute force solution
# Time Complexity : O(m *n)^2
# Space Complexity : O(1)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        max_curr = 0
        m, n = len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    curr = 1
                    flag = True
                    while i + curr < m and j + curr < n and flag:
                        for k in range(i+curr, i-1, -1):
                            if matrix[k][j+curr] == '0':
                                flag = False
                                break
                        for k in range(j+curr, j-1, -1):
                            if matrix[i+curr][k] == '0':
                                flag = False
                                break
                        
                        if flag:
                            curr += 1
                            
                    max_curr = max(max_curr, curr)
        return max_curr **2


# DP Solution
# Time Complexity : O(m *n)
# Space Complexity : O(m * n)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        max_curr = 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                    max_curr = max(max_curr, dp[i][j])
        return max_curr ** 2




# DP Solution
# Time Complexity : O(m *n)
# Space Complexity : O(n)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        max_curr = 0
        m, n = len(matrix), len(matrix[0])
        dp = [0] * (n+1)
        prev = 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    temp = dp[j]
                    dp[j] = min(dp[j], dp[j-1], prev) + 1
                    prev = temp
                else:
                    dp[j] = 0
                max_curr = max(max_curr, dp[j])
        return max_curr **2
        
        