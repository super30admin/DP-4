# // Time Complexity :O((m*n)
# // Space Complexity :O(m)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m=len(matrix)
        n=len(matrix[0])
        ma=0
        dp=[0 for i in range(n+1)]
        temp=0
        temp2=0
        print(dp)
        for i in range(1,m+1):
            
            for j in range(1,n+1):
                temp=dp[j]
                if matrix[i-1][j-1]=='1':
                    print(matrix[i-1][j-1])
                    print(dp[j])
                    print(temp)
                    dp[j]=min(dp[j],dp[j-1],temp2)+1
                else:
                    dp[j]=0
                temp2=temp
                ma=max(ma,dp[j])
            print(dp)
        return ma*ma
        
                    

        
                    
                        
                        
        