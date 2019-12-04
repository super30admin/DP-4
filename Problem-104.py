'''
leetcode- 221 - Maximal Square - https://leetcode.com/problems/maximal-square/
time complexity - O(M^2 *N^2)
approach - recursive (we traverse through diagonal and check the top column and left right values of the sliding diagonal

'''

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        row=len(matrix)
        
        #edge case
        if row==0:
            return 0
        col=len(matrix[0])
        max_count=0
        flag= False
        for i in range(row):
            for j in range(col):
                if matrix[i][j]=='1':
                    flag= True
                    curr=1
                    
                    #window diagonal
                    while i+curr<row and j+curr<col and flag:
                        ##columns J+K
                        for k in range(i+curr,i-1,-1):
                            if matrix[k][j+curr]=='0':
                                flag = False
                                break;
                                
                        ##rows
                        for k in range(j+curr,j-1,-1):
                            if matrix[i+curr][k]=='0':
                                flag = False
                                break;
                        if flag:
                            curr=curr+1
                    max_count=max(max_count,curr)
        return max_count*max_count
    
    
 ''' 
 approach - DP solution, we have check all three sides of DP array and consider the minimum of it
 '''



 class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        row=len(matrix)
        
        #edge case
        if row==0:
            return 0
        col=len(matrix[0])
        max_count=0
        dp=[[0 for i in range(col+1)] for j in range(row+1)]
        for i in range(1,len(dp),1):
            for j in range(1,len(dp[0]),1):
                if matrix[i-1][j-1]=='1':
                    dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
                    max_count=max(max_count,dp[i][j])
                    
                    
        return max_count*max_count
                        
                    