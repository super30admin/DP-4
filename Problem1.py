#Time complexity is O(m*n)
#Space complexity is O(m*n)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        #Base case
        if(matrix==None or len(matrix)==0):
            return None
        #initializing all the required variables
        maxi=0
        m=len(matrix)
        n=len(matrix[0])
        #Creating a dp matrix of size m+1*n+1
        dp=[[0 for k in range(0,n+1)]for l in range(0,m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                #If the value of matrix at i-1 and j-1 index is equal to 1
                if(matrix[i-1][j-1]=='1'):
                    #THen we will find the minimum value in 3 directions 
                    #and we will add 1 to that
                    dp[i][j]=1+min(dp[i][j-1],min(dp[i-1][j-1],dp[i-1][j]))
                    #We will be taking the making size of the square
                    maxi=max(maxi,dp[i][j])
        #Finally we will be returning the maximum are of the square
        return maxi*maxi
