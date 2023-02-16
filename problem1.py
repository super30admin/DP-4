#time O(N*N)
#space O(N*N)

class Solution:
    # def maximalSquare(self, matrix: List[List[str]]) -> int:
        
#         def helper(data,i,j,memo):
#             # if i==j and int(data[i][j])==1 :
#             #     return 1
#             if memo[i][j]!=None:
#                 return memo[i][j]
#             if i+1>=r or j+1>=c:
#                 return 
#             print(i,j)
#             if int(data[i+1][j])==1 and int(data[i][j+1])==1:
#                 memo[i][j]=1
#             if int(data[i+1][j])==1:
#                 helper(data,i+1,j,memo)
#                 # memo[i][j]=result
#                 # return memo
#             if int(data[i][j+1])==1:
#                 helper(data,i,j+1,memo)     
#             return
#         r=len(matrix)
#         c=len(matrix[0])
#         memo= [ [ None for y in range(0,len(matrix[0]) ) ] for x in range(0,len(matrix)) ]

#         for i,j in zip(matrix,range(0,len(matrix))):
#             for k,l in zip(i,range(0,len(i))):
#                 if int(matrix[j][l])==1:
#                     helper(matrix,j,l,memo)
#         print(memo)
        def maximalSquare(self, matrix):
            if not matrix:
                return 0
            m,n = len(matrix), len(matrix[0])
            dp = [[int(matrix[i][j]) for j in range(n)] for i in range(m)]
            for i in range(1,m):
                for j in range(1,n):
                    if dp[i][j]==1:
                        dp[i][j] = min(dp[i][j-1],dp[i-1][j-1],dp[i-1][j])+1
            max_area = max(max(x) for x in dp)            
            return max_area**2