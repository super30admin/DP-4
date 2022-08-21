# Time complexity: O(mn)
# Space complexity: O(mn)
# Approach: use dynamic programming.
# create a dp array of one row and one col more than the given matrix to take care of edge cases
# traverse the elements in matrix from first index
# if matrix element is '1', then check in the dp array for minimum value between diagonal, up, left and add 1 to this minimum value
# update the max value with max of current dp value and past max value
# return square of max


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        maxi = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        print(dp)
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
                maxi = max(maxi, dp[i][j])
        return maxi*maxi
        
        