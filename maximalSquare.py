class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        max_ans = 0
        rows, cols = len(matrix), len(matrix[0])
        dp = [[0]*cols for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if i==0 or j==0:
                    dp[i][j] = int(matrix[i][j])
                elif matrix[i][j] == '0':
                    dp[i][j] = 0
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                max_ans = max(max_ans, dp[i][j])
        return max_ans ** 2
        
#         Solution 2 O(n) space
        dp= [0] * cols
        ans = 0
        for row in range(rows):
            for col in range(cols):
                temp = dp[col]
                if row == 0 or col == 0:
                    dp[col]= int(matrix[row][col])
                elif matrix[row][col] == '0':
                    dp[col] = 0
                else:
                    dp[col] = min(dp[col], prev, dp[col-1]) + 1
                ans = max(ans,dp[col])
                prev = temp
        
        return ans ** 2
                    
