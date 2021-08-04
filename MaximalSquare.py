# TC: O(M x N) where M is the number of rows and N is the number of columns of the input matrix.
# TC: O(M x N) as we are using a dp matrix of input size to store the temporary results. 

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix[0]) == 0: 
            return 
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        dp = [[0 for i in range(cols + 1)] for _ in range(rows + 1)]
        max_area = 0
        
        for i in range(1, rows + 1): 
            for j in range(1, cols + 1): 
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j - 1], dp[i][j - 1]) + 1
                    max_area = max(max_area, dp[i][j])

        return max_area*max_area
