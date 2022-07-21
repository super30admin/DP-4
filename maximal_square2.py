# // Time Complexity :O((m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m=len(matrix)
        n=len(matrix[0])
        ma=0
        dp=[[0 for i in range(n+1)]for j in range(m+1)]
        print(dp)
        for i in range(1,m+1):
            for j in range(1,n+1):
                
                if matrix[i-1][j-1]=='1':
                    print(matrix[i-1][j-1])
                    print(dp[i][j])
                    dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
                    ma=max(ma,dp[i][j])
        return ma*ma
        
                    

        
                    
                        
                        
        