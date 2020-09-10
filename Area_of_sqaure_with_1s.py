class Solution(object):
    def maximalSquare(self, matrix):
        if matrix==None or len(matrix)==0:
            return 0
        rows=len(matrix)
        columns=len(matrix[0])
        dp=[[0 for i in range(columns+1)] for j in range(rows+1)]
        maxlen=0
        for i in range(1,rows+1):
            for j in range(1,columns+1):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=min(min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1
                    maxlen=max(maxlen,dp[i][j])
        return maxlen*maxlen
#Time-Complexity: O(m.n)
#Space-complexity: O(m.n)