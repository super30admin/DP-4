"""
TC-O(MN)
SC=O(MN)

"""


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None  and len(matrix)==0:
            return 0
        rows=len(matrix)
        cols=len(matrix[0])
        max1=0
        dp=[[0]*(cols+1) for _ in range(rows+1)]
        
        #dp=[[0]*(n+1)]*(m+1)  ------->This assignemnet is wrong . It creates reference.
        for i in range (1,len(dp)):
            for j in range (1,len(dp[0])):
                if(matrix[i-1][j-1]=='1'):
                    dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
                    max1=max(max1,dp[i][j])
        
        return max1*max1
                
        
        