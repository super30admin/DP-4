#Time Complexity :o(mn)
#Space Complexity :o(mn)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        m=len(matrix)
        n=len(matrix[0])
        dp=[0]*(m+1)
        arr=[0]*(n+1)
        for i in range(len(dp)):
            dp[i]=copy.deepcopy(arr)
        ans=0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if(matrix[i-1][j-1]=='1'):
                    #min btwn left up nd digonal 
                    maxi=min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])
                    dp[i][j]=maxi+1
                    #update ans with maxi value
                    if(ans<dp[i][j]):
                        ans=dp[i][j]
                else:
                    dp[i][j]=0
        return ans*ans
        
            