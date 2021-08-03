class Solution:
    #Approach 1: DP
    """
    
    TC: O(mn)
    SC: O(mn)
    """
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0]*(n+1) for _ in range(m+1)]
        max_side = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                    max_side = max(max_side, dp[i][j])
        return max_side**2
    
    # Approach 2: optimized TC
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        dp = [0]*(n+1)
        max_side = 0
        prev = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == "1":
                    temp = dp[j]
                    dp[j] = min(dp[j-1], dp[j], prev) + 1
                    prev = temp
                    max_side = max(max_side, dp[j])
                else:
                    dp[j] = 0
        return max_side**2