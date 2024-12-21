# Time:O(m*n)
# Space:O(m*n) for dp matrix O(m) for dp array; O(1) for inplace
# Leetcode: Yes
# Issues: range(m+1) if <=m ;range(m) if <m ; reverse is (m-1,-1,-1)

#114 ms - dp matrix
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dp = [[0]*(n+1) for i in range(m+1)]
        cnt = 0

        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1                #minimum +1
                    cnt = max(cnt, dp[i][j])
        return cnt*cnt
                
#261 ms - My first solution      Space: O(1) 
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0

        m = len(matrix)
        n = len(matrix[0])

        count = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1' and i > 0 and j > 0:
                    matrix[i][j] = str(min(int(matrix[i-1][j]), int(matrix[i][j-1]), int(matrix[i-1][j-1])) + 1)
                count = max(count, int(matrix[i][j]))
        
        return count*count
    
#124 ms - dp matrix but reverse
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dp = [[0]*(n+1) for i in range(m+1)]
        cnt = 0

        for i in range(m-1,-1,-1):                                                  # m-1,-1,-1 
            for j in range(n-1,-1,-1):
                if matrix[i][j] == "1":
                    dp[i][j] = min(dp[i+1][j],dp[i][j+1],dp[i+1][j+1])+1
                    cnt = max(cnt, dp[i][j])
        return cnt*cnt
                
#115 ms dp array class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dp = [0]*(n+1)
        cnt = 0
        diag = 0                                # special diagonal must be store on the previous step so that its not lost for next item
        for i in range(1,m+1):
            for j in range(1,n+1):
                temp = dp[j]
                if matrix[i-1][j-1] == "1":
                    dp[j] = min(dp[j],dp[j-1],diag)+1
                    cnt = max(cnt, dp[j])
                else:
                    dp[j] = 0                   
                diag = temp                     # old diag 

        return cnt*cnt
                
#104 ms -using temp in dp array(same as previous)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])

        dp = [0]*(n+1)
        cnt = 0
        diag = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == "1":
                    temp = dp[j]                                #store
                    dp[j] = min(dp[j],dp[j-1],diag)+1
                    cnt = max(cnt, dp[j])
                    diag = temp 
                else:
                    dp[j] = 0
                
        return cnt*cnt