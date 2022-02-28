'''
TC: O(m*n)
SC: O(m*n)

Intuition:

- bottom up dp

'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rlen = len(matrix)
        if not rlen:
            return 0
        
        clen = len(matrix[0])
        dp = list()
        maxm = 0
        
        for i in range(rlen):
            rlist = list()
            for j in range(clen):
                if matrix[i][j] == "1":
                    maxm = 1
                rlist.append(int(matrix[i][j]))
            dp.append(rlist)
                
        
        for i in range(1, rlen):
            for j in range(1, clen):
                if matrix[i][j] == "0":
                    continue
                dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                maxm = max(maxm, dp[i][j] ** 2)
        
        return maxm