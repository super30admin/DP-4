#Time Complexity:O(mn)
#Space Complexity:O(mn)
#ran successfully on Leetcode:yes
#Algorithm: 
#1.Create a dp array for extra row and col. 
#2. iterate thru array and check for 1:
#of yes check if its diagnol elements has 1 and calulate min+1 and calculate max square from calculate value
#return max*max 

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        #base
        if not matrix:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        dp = [[0 for j in range(n+1)] for i in range(m+1)]
        maxS=0
        
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=1+min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])
                    maxS=max(maxS,dp[i][j])
        return maxS*maxS
                    
                    
            
        
            
        
        
