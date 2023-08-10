"""
Problem : 1

Time Complexity : O(n^2)

Space Complexity : 
Recursion - O(m^2*n^2)
DP Matrix - O(m*n)
DP Array - O(n)


Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Maximal square

# Approach - 1
# Bruteforce

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """

        if not matrix:
            return 0
        maxx=0
        m=len(matrix)
        n=len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j]=='1':
                    flag=True
                    l=1
                    while i+l<m and j+l<n and flag:

                        #  column
                        for k in range(i+l,i-1,-1):
                            if matrix[k][j+l]=='0':
                                flag=False
                                break
                        #  row
                        for k in range(j+l,j-1,-1):
                            if matrix[i+l][k]=='0':
                                flag=False
                                break
                        if flag:
                            l+=1
                    maxx=max(maxx,l)

        return maxx*maxx
    
# Approach - 2
# DP Matrix

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        dp=[[0 for _ in range(n+1)] for _ in range(m+1)]
        maxx=0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=="1":
                    dp[i][j]=min(dp[i-1][j],min(dp[i-1][j-1],dp[i][j-1]))+1
                    maxx=max(maxx,dp[i][j])
        return maxx*maxx
    
# Approach - 3
# DP Array

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        dp=[0 for _ in range(n+1)]
        maxx=0
        for i in range(1,m+1):
            diagUp=0
            for j in range(1,n+1):
                temp=dp[j]
                if matrix[i-1][j-1]=="1":
                    dp[j]=min(dp[j],min(dp[j-1],diagUp))+1
                    maxx=max(maxx,dp[j])
                else:
                    dp[j]=0
                diagUp=temp
        return maxx*maxx