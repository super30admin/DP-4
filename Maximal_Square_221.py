# Time - O(m.n)
# Spac - O(m.n)

# Algo -
# Found the pattern where --
# To form a square had to check the --
# * row - 1,col
# * row, col-1
# * row-1, col - 1

# From the 3 coordinates find the min and add  +1

# In the end check for the max value inbetween the dp matrix 

//Brute Force::
def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix)==0:
            return 0
        res = 0
        
        row = len(matrix)
        col = len(matrix[0])
        
        for r in range(row):
            for c in range(col):
                if matrix[r][c] != '1':
                    continue
                
                count = 1
                flag = True
                
                while flag and (r + count) < row and (c+count) < col:
                    # if matrix[r+count][c+count] !='1':
                    #     flag = False
                    #     break
                    
                    for k in range(r, count + r + 1):
                        if matrix[k][c + count ] == '0':
                            flag = False
                            break
                    for k in range(c, count + c + 1):
                        if matrix[r + count][k] == '0':
                            flag = False
                            break
                    if flag:
                        count +=1
                res = max(res,count)
        return res * res


//Using DP

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix)==0:
            return 0
        res = 0
        
        row = len(matrix)
        col = len(matrix[0])
        
        dp = [[0 for i in range(col + 1)] for j in range(row + 1)]
        
        for i in range(1,row+ 1):
            for j in range(1,col+ 1):
                if matrix[i- 1][j - 1] == '1':
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
                    
        s = max([max(r) for r in dp])
        return s * s        
