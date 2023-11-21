# // Time Complexity :O(mn)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we craete a dparray to store the values and an extra variable to store the diagonal up. we check each time if we can get a square at any given point and keep updating the dp array
# we implemented both DP solutions iwth dp matrix and dp array
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # DP O(mn), O(mn)
        # if(len(matrix)==0):
        #     return 0
        # maxel=0
        # m,n=len(matrix), len(matrix[0])
        # dp=[[0 for i in range(n+1)] for j in range(m+1)]
        # for i in range(1,m+1):
        #     for j in range(1,n+1):
        #         if(matrix[i-1][j-1]=="1"):
        #             dp[i][j]=1+min(dp[i-1][j], min(dp[i-1][j-1],dp[i][j-1]))
        #             maxel=max(maxel,dp[i][j])
        # return maxel*maxel

        # DP with O(mn), O(n) : we just need a 1D Dp array instead of matrix
        # we will need to store diagonal-up in a variable
        if(len(matrix)==0):
            return 0
        maxel=0
        m,n=len(matrix), len(matrix[0])
        dp=[0 for i in range(n+1)] 
        for i in range(1,m+1):
            diagup=0
            for j in range(1,n+1):
                if(matrix[i-1][j-1]=="1"):
                    temp=dp[j]
                    dp[j]=1+min(dp[j], min(diagup,dp[j-1]))
                    maxel=max(maxel,dp[j])
                    diagup=temp
                else:
                    dp[j]=0
        return maxel*maxel