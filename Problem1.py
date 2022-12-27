#TC: O(m*n)
#SC: O(n)

#Approach
# Use a DP array to store maximum size of previous row's squares,
# At any point maximal size square = min(up, left and up diagonal) if arr[i][j] == 1 else 0
# Keep track of max square size computed using a max variable

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        #rows
        m = len(matrix)
        #cols
        n = len(matrix[0])
        
        dp = [int(x) for x in matrix[0]]
        
        maxVal = 0
        for x in dp:
            maxVal = max(x, maxVal)

        for i in range(1, m):
            diagUp = 0
            for j in range(n):
                    if matrix[i][j] == "1":
                        up = dp[j]
                        left = dp[j-1] if j >= 0 else 0
                        temp = dp[j]
                        dp[j] = min(up, left, diagUp) + 1
                        maxVal = max(maxVal, dp[j])
                        diagUp = temp
                    else:
                        temp = dp[j]
                        dp[j] = 0
                        diagUp = temp
# 1 1 1
                
                
        return maxVal * maxVal
