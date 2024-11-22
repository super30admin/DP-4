#Time Complexity: O(m×n) since we iterate through all cells once.
#Space Complexity: O(m×n) for the dp array.
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        area = 0 
        m = len(matrix)
        n = len(matrix[0])
        #Assign a dp matrix with one extra row and column to calculate the area of each cell in the first 1st row and column in input matrix
        dp = [[0]*(n+1) for k in range(m+1)]
        #Range is considered from 1 to avoid out of bound for cells in 1st row and column
        for i in range(1,m+1):
            for j in range(1,n+1):
                #We calculate the area in dp matrix for that cell only if it's 1 in input matrix or else it remains 0 in dp matrix as it's assigned with 0's
                if(matrix[i-1][j-1]=="1"):
                    #This loops is executed when the cell is 1 so the minimum area should be atlest 1 so we consider 1 + whatever the calculation
                    dp[i][j] = 1+min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]))
                    area = max(area,dp[i][j])
        #Finally after calculating all cells we will have the maximum area in area variable
        return area**2

        

        