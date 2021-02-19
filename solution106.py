#Time Complexity:O(mn)
#Space Complexity:O(mn)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix)==0:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        mx=0 																#create a variable to hold max value
        dp=[[0 for i in range(n+1)] for j in range(m+1)]					#create a dp array of size m+1*n+1
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=="1": 									#if value at i-1 and j-1 in matrix is 1
                    dp[i][j]=1+min([dp[i-1][j],dp[i-1][j-1],dp[i][j-1]])	#add 1 to the minimum value amongst left, up and diagonal left up value
                    mx=max([mx,dp[i][j]]) 									#update maximum
        return mx*mx 
        														#return maximum square
#Time Complexity:O(mn)
#Space Complexity:O(n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix)==0:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        mx=0
        dp=[0 for i in range(n+1)]                              #create a dp array of size n
        prev=0                                                  #a variable that hold the value of diagonal top left element 
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=="1":                       #If 1 is encountered 
                    temp=dp[j]                                  #store current value as temp
                    dp[j]=1+min([temp,dp[j-1],prev])            #add 1 to the minimum value amongst left, up and diagonal left up value
                    mx=max([mx,dp[j]])                          #update maximum
                    prev=temp                                   #update prev to be temp
                else:
                    dp[j]=0                                     #if zero is encounterede update the value to be zero
        return mx*mx