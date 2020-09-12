#Time complexity - O(m*n)
#Space complexity - O(m*n) but O(1) if I modify the input matix itself for dp
#Works on leetcode - yes
#Approach - We generate a clone of input matrix for dp and iterate through it. If we find 1, then we have one more unit for
#the side of maximal square + min of(previous max side at any of left, up and up-left) to current position. We find max value
#and then return the area 

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0 if matrix[i][j]=='0' else 1 for j in range(n)] for i in range(m)]
        
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i][j]=='1':
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])+1
                else:
                    dp[i][j]=0
        s = max([max(r) for r in dp])
        return s *s