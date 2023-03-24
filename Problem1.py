#Time Complexity :- O(mxn)^2
#Space Complexity :- O(1)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        maxValue = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    flag = True
                    curr = 1
                    while i + curr < m and j + curr < n and flag:
                        for k in range(i + curr, i-1, -1):
                            if matrix[k][j + curr ] == '0':
                                flag = False
                                break
                        
                        for k in range(j + curr, j-1, -1):
                            if matrix[i + curr][k] == '0':
                                flag = False
                                break 

                        if flag:
                            curr += 1
                    maxValue = max(maxValue, curr)
        
        return maxValue * maxValue


#Another approach using DP
#Time Complexity :- O(mxn)
#Space Complexity :- O(mxn)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        dp = []
        m = len(matrix)
        n = len(matrix[0])
        maxValue = 0
        for i in range(m+1):
            dp.append([])
            for j in range(n+1):
                dp[i].append(0)

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    minValue = min(dp[i][j], dp[i][j+1], dp[i+1][j])
                    dp[i+1][j+1] = minValue + 1
                    maxValue = max(maxValue, dp[i+1][j+1])
        return maxValue * maxValue
        
 # Single row dp appraoch        
#Time Complexity :- O(mxn)
#Space Complexity :- O(n) where n is the length of column
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        dp = []
        m = len(matrix)
        n = len(matrix[0])
        maxValue = 0
        diagonal = 0
        for i in range(n+1):
            dp.append(0)

        for i in range(m):
            for j in range(n):
                temp = dp[j+1]
                if matrix[i][j] == '1':
                    dp[j+1] = min(dp[j], min(dp[j+1], diagonal)) + 1
                    maxValue = max(dp[j+1] ,maxValue)
                else:
                    dp[j+1] = 0
                diagonal = temp
        return maxValue * maxValue
        
        
                        