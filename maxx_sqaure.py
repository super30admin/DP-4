class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        DP
        TC:O(row*col)
        SC:O(row*col)
        """
        m=matrix
        row=len(m)
        col=len(m[0])
        dp =[[0]*(col+1) for i in range(row+1)]
        maxx=0
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                if m[i-1][j-1]=='1':
                    dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
                    maxx=max(maxx, dp[i][j])
        return maxx*maxx
                    
            
        
        
        # """
        # Brute Force
        # TC:O(row*col*row*col)
        # SC:O(1)
        # """
        # m=matrix
        # if not m:
        #     return m
        # row=len(m)
        # col=len(m[0])
        # # dp=[[0]*(col) for i in range(row)]
        # # print(dp)
        # flag=False
        # maxside=0
        # for i in range(row):
        #     for j in range(col):
        #         if m[i][j]=='1':
        #             flag=True
        #             cur=1
        #             while(i+cur<row and j+cur<col and flag):
        #                 #col from  diagonal down
        #                 for k in range(i+cur, i-1, -1):
        #                     if m[k][j+cur]=='0':
        #                         flag=False
        #                         break
        #                 # row from diagonal down
        #                 for k in range(j+cur, j-1, -1):
        #                     if m[i+cur][k]=='0':
        #                         flag=False
        #                         break
        #                 if flag==True:
        #                     cur+=1
        #             maxside=max(maxside, cur)
        # return maxside*maxside