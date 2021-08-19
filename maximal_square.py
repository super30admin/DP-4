#Time Complexity : O(MN)
#space complexity : O(N)


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maximum ,prev=0,0
        dp = [ 0 for i in range(n)]
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                temp = dp[j]
                if(matrix[i][j] == "1" and (i!=0 and j!=0)):
                    dp[j]= min(dp[j-1],dp[j],prev) +1
                else:
                    dp[j] = int(matrix[i][j])
                maximum = max(maximum,dp[j])
                prev = temp
        return maximum**2
        