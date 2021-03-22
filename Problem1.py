"""
221. Maximal Square
Time Complexity - O(n*m)
Space Complexity - O(n*m)
Create a dp array where value in dp is incremented with considering its diagonal,below and right element and size of matrix is max_element * max element"""
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        
        dp =[[0]*len(matrix[0])]* len(matrix)
        max_val = float("-INF")
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1+ min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]))
                    max_val = max(max_val,dp[i][j])
        return max_val * max_val
        