class Solution:
    '''
    T = O(N*N)
    S = O(N*N)
    '''
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [ [ int(0) for x in range(cols)] for x in range(rows) ]
        ans = 0
        for row in range(rows-1, -1, -1):
            for col in range(cols-1, -1, -1):
                if row == rows-1 or col == cols-1:
                    dp[row][col] = int(matrix[row][col])
                elif matrix[row][col] == "0":
                    dp[row][col] = 0 
                elif row + 1 <= rows -1 and col+1 <= cols-1:
                    dp[row][col] = int(matrix[row][col]) + min( dp[row + 1][col ] ,
                                                           dp[row][col+1] ,
                                                           dp[row+1][col+1] )
                ans = max(ans, dp[row][col] )
        # print(dp) 
        return ans*ans
    
    
    
