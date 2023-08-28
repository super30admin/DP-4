class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxdimension = 0
        

        # #for each element in the array, diagonally (bottom left) iterate and check from that point to up till i and left till j if all is 1. If it is, continue the diagonal iteration, else immediately stop.
        # for i in range(m): #m
        #     for j in range(n): #n
        #         if matrix[i][j] == '1':
        #             l = 1
        #             flag = True
        #             while flag and i + l < m and j + l < n: #mn
        #                 # Left check - row check from curr to i
        #                 for k in range(i + l, i-1, -1):
        #                     if matrix[k][j + l] == '0':
        #                         flag = False
        #                         break
        #                 # Up check - col check from curr to j
        #                 for k in range(j + l, j-1, -1):
        #                     if matrix[i + l][k] == '0':
        #                         flag = False
        #                         break
        #                 if flag:
        #                     l += 1
        #             print(l,i,j)
        #             maxdimension = max(maxdimension, l)
        
        # return maxdimension * maxdimension

        #DP -2D array - TC and SC - O(m*n)
        dp=[[0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=1+min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])
                    maxdimension = max(maxdimension, dp[i][j])
        return maxdimension * maxdimension

        

                            
                            
