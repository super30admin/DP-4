# Time Complexity : O(m*n), Where m,n are number of rows, columns in matrix array respectively
# Space Complexity : O(n), Where n is number of elements in matrix array row or number of columns in matrix array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if(len(matrix)==0):
            return 0
        #This is modification of the previous solution
        out=0
        m=len(matrix)#Number of rows
        n=len(matrix[0])#Number of columns
        dp=[0 for i in range(n+1)]
        for i in range(1,m+1):
            temp=[0]#This is temporary variable which will be used to modify the dp after each level
            prev=temp[0]
            for j in range(1,n+1):
                if(matrix[i-1][j-1]=="1"):
                    sol=(min(dp[j-1],dp[j],prev))+1
                    temp.append(sol)
                      
                else:
                    sol=0
                    temp.append(sol)
                out=max(sol,out)
                prev=temp[j]#or sol
            #print(temp)
            dp=temp
  
        return out*out
                        
                