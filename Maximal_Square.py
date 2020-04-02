// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

In this problem we need to break it into smaller problems and then solve it.As it is a square we start with one element if it is 1 then it is 1*1 matrix.we need to traverse through the whole matrix and use the output from the prev results and then fill in the current.For instance to get a square of 2*2 From the element that we are at all the surrounding elements should be 1 then only it will be a square.if it is not it will be the order of the current element.From the above we got to know that we need take the min of the surrounding elements and add 1 to it to get the current element order in the matrix.In this manner at every computation we need to store the maximum order which gives the side of the maximal square.

# Time complexity --> o(mn)
# space complexity --> o(mn)
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        
        if matrix==None or len(matrix)==0:
            return 0
        maxi=0
        dp=[[0 for i in range(len(matrix[0]))]for j in range(len(matrix))]
        for i in range(len(matrix)):
            if matrix[i][0]=='1':
                dp[i][0]=1
                maxi=1
        for j in range(len(matrix[0])):
            if matrix[0][j]=='1':
                dp[0][j]=1
                maxi=1
        
        
        for i in range(1,len(matrix)):
            for j in range(1,len(matrix[0])):
                if matrix[i][j]=='1':
                    dp[i][j]=1+min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])
                    maxi=max(maxi,dp[i][j])

        return(maxi*maxi)