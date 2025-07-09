# TimeComplexity: O(m x n) m -cols, n-rows
# SpaceComplexity:O(n)
# Approach:
# BruteForce: if you encoter a 1 you should expand on right and down , check if there any zeros in thta row and col if no then move ot next row and col ..based on that update ans and return ans*ans
# Optimal:but for same adjacent 1's you are doing same work again and again which are repetaed sub problems
# dp[i][j]=min(side, down , diagonal)+1
# space optimal: we dont need m x n dp matrix .more on we just need right (j+1) and j (before updating its dp val of below row) and diagonal(we can save this before updating dp[j])
 # dp[row]=0 #this is very important you missied this



class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        c,r=len(matrix),len(matrix[0]) #[c][r]
        dp=[ 0 for i in range(r+1)]
        maxAns=0
        prev_before_update=0
        for col in range(c-1,-1,-1):
            for row in range(r-1,-1,-1):
                if matrix[col][row]=="1":
                    t=dp[row]
                    dp[row]=min( dp[row], prev_before_update, dp[row+1])+1
                    maxAns=max(maxAns,dp[row])
                    prev_before_update=t
                else:
                    dp[row]=0 #this is very important you missied this

       
        return maxAns*maxAns




class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        c,r=len(matrix),len(matrix[0]) #[c][r]
        dp=[[ 0 for i in range(r+1)] for j in range(c+1)]
        maxAns=0
        for col in range(c-1,-1,-1):
            for row in range(r-1,-1,-1):
                if matrix[col][row]=="1":
                    dp[col][row]=min( dp[col+1][row], dp[col][row+1], dp[col+1][row+1])+1
                    maxAns=max(maxAns,dp[col][row])
        # for i in dp:
        #     print(i)
        #     print()
        return maxAns*maxAns



class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        #brute force , if current nuber an diagaonal is 1 then expand
        ans=0
        r,c=len(matrix),len(matrix[0]) #[r][c]
        for i in range(r):
            for j in range(c):
               if matrix[i][j]=="1":
                l=1
                flag=True
                while(i+l<r and j+l<c and flag):
                    #check row
                    #going up
                    for ti in range(i+l,i-1,-1):
                        if matrix[ti][j+l]=="0":
                            
                            
                            flag= False
                            break
                    for tj in range(j+l,j-1,-1):
                        if matrix[i+l][tj]=="0":
                            
                            flag= False
                            break
                    if flag:
                        # print(flag,i+l,j+l)
                        l+=1
                ans=max(ans,l)
        return ans*ans
