# DP Solution
# Time Complexity = O(m * n)
# Space Complexity = O(n)


class Solution:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        
        maxS = 0
        m = len(matrix)
        n = len(matrix[0])
        # Adding an extra row on top and col on left to avoid handling out of index cases
        dp = [0 for i in range(n + 1)] 
        prev = 0
        temp = 0
        
        
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                temp = dp[j]
                if matrix[i - 1][j - 1] == '1':
                    dp[j] = min(dp[j - 1], min(dp[j], prev)) + 1 
                    
                    maxS = max(maxS, dp[j])
                                
                else:
                    dp[j] = 0
                                
                prev = temp
                    
        return maxS * maxS
                  




# DP Solution
# Time Complexity = O(m * n)
# Space Complexity = O(m * n)


class Solution:
    def maximalSquare(self, matrix: list[list[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        
        maxS = 0
        m = len(matrix)
        n = len(matrix[0])
        # Adding an extra row on top and col on left to avoid handling out of index cases
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
        
        
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == '1':
                    dp[i][j] = min(dp[i][j - 1], min(dp[i - 1][j], dp[i - 1][j - 1])) + 1 
                    
                    maxS = max(maxS, dp[i][j])
                    
        return maxS * maxS
                  

