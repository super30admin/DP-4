#All TC passed on leetcode

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:

          #Here we traveerse each cell starting row=1 and col=1, and check if cell is 1. If yes then we take min of its left, up and diag elements plus 1 (cur cell) else we proceed. So each cell holds the max sqaure possible from its position.
        #Time complexity - O(m.n)
        #Space complexity - O(1)
        m = len(matrix)
        n = len(matrix[0])
        res = 0

        #check if col=0 has 1 cell
        for i in range(m):
            if matrix[i][0]=="1":
                res = 1

         #check if row=0 has 1 cell
        for j in range(n):
            if matrix[0][j]=="1":
                res = 1
        
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j]=="1":
                    up = int(matrix[i-1][j])
                    left = int(matrix[i][j-1])
                    diag = int(matrix[i-1][j-1])
                    matrix[i][j] = 1 + min(up, left, diag)
                    res = max(res, matrix[i][j])
        
        return res*res
        



#-------------------------------------OR------------------------------------------


        #Here we traveerse each cell, if cell is 1 then we go diagnoally downwards untill 0 is encountered. For each diagonally downward cell we check corresponding upward rows and leftward columns for 1. We make note of max square size.
        #Time complexity - O(m.n)^2 - as for each cell we may have to traverse full matrix
        #Space complexity - O(1)
        m = len(matrix)
        n = len(matrix[0])
        res = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j]=="1":
                    k=1
                    res = max(res, k)
                    flag = True
                    while (i+k)<m and (j+k)<n and flag:
                        for r in range(i+k, i-1, -1):
                            if matrix[r][j+k]!="1":
                                flag=False
                                break
                        
                        for c in range(j+k, j-1, -1):
                            if matrix[i+k][c]!="1":
                                flag=False
                                break
                        

                        k+=1
                        if flag:
                            res = max(res, k)
        
        return res*res
                    

                                