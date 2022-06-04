#Time Complexity: O(MN)
#Space Complexity: O(N) ROW ELEMENTS
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        row = len(matrix)
        col = len(matrix[0])
        dp = [0]* (col+1)
        maxx = 0
        for i in range(1,row+1):
            diag = 0
            for j in range(1,col+1):
                temp = dp[j]
                if matrix[i-1][j-1] == '1':
                    dp[j] = 1 + min(dp[j],min(dp[j-1],diag))
                    maxx = max(maxx,dp[j])
                    diag = temp
                else:
                    dp[j] = 0
        return maxx * maxx
                            
                    