class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # Time Complexity - O(M*N)
        # Space Complexity - O(M*N)
        
        maxLen = 0 # Defining variable to store maximum length of the square
        # Base Case
        if len(matrix)==0 or len(matrix[0])==0:
             return maxLen
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        dp = [[0]*(cols+1) for _ in range(rows+1)]
        
        for i in range(1,rows+1): # We are starting from 1 because in dp array our 0th row and 0th col is 0 to cover the corner case and +1 since in matrix array we are one step back
            for j in range(1,cols+1):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
                    maxLen = max(maxLen,dp[i][j])

        
        return maxLen*maxLen