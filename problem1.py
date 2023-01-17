#time complexity:O(m*n)
#space complexity : O(m*n)
#ran on leetcode: Yes
#All values in dp array are zero initailly. If a element (i,j) in 1, then look at left and top to get the number of squares that can be formed. 
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        dp=[]
        best=0
        for i in range(len(matrix)+1):
            temp=[]
            for j in range(len(matrix[0])+1):
                temp.append(0)
            dp.append(temp)
        
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                if(matrix[i][j]=='1'):
                    dp[i+1][j+1]=1+min(dp[i][j],dp[i][j+1],dp[i+1][j])
                    best=max(best,dp[i+1][j+1]*dp[i+1][j+1])
        
        #print(dp)
        return best



        

        
