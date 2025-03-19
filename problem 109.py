#  https://leetcode.com/problems/maximal-square/

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        max_ans = 0
        dp = [[0] * (n+1) for _ in range(m+1)]

        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if matrix[i][j]=='1':
                    dp[i][j] = 1 + min(dp[i+1][j], min(dp[i][j+1], dp[i+1][j+1]))
                max_ans =  max(max_ans,dp[i][j])

        return max_ans * max_ans
        
# TC: O(mn)
# SC: O(mn)

##################### spac optimization #####################

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        max_ans = 0
        dp = [0] * (n+1)

        for i in range(m-1,-1,-1):
            diagDown = 0
            for j in range(n-1,-1,-1):
                temp = dp[j]
                if matrix[i][j]=='1':
                    dp[j] = 1 + min(dp[j], min(dp[j+1], diagDown))
                    max_ans =  max(max_ans,dp[j])
                else:
                    dp[j] = 0
                diagDown = temp

        return max_ans * max_ans
        
# TC: O(mn)
# SC: O(n)