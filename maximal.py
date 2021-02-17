# Brute force
# TC: O(mn**2)
# Sc: O(1) 
# At every element- we traverse diagonally to the extent to which adjacent left and top cells have '1' up until element of consideration. We record max extent. 

def maximal(matrix):
    if not matrix: return 0
    m, n = len(matrix), len(matrix[0])
    flag, msaximal = False, 0

    for i in range(m):
        for j in range(n):
            if matrix[i][j] == '1':
                flag = True
                curr = 1
                while i+curr < m and j+curr < n and flag:
                    # column check
                    for k in range(i+curr, i-1, -1):
                        if matrix[k][j+curr] == '0':
                            flag = False
                            break
                    # column check
                    for k in range(j+curr, j-1, -1):
                        if matrix[i+curr][k] == '0':
                            flag = False
                            break
                    if flag: curr += 1
                maximal = max(maximal, curr)
    return maximal * maximal

matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]

print(maximal(matrix))

# DP
# matrix
# TC: O(mn), SC: O(mn)
# Subproblem- at each cell we store max length of square that could be formed up until that cell
# how? at each cell, we take 1 + min(cell above, cell left, cell diagonal)
class Solution:
    def maximalSquare(self, matrix):
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        maximal = 0
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        
        for i in range(1,m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                    maximal = max(maximal, dp[i][j])
        return maximal * maximal

# DP
# array
# TC: O(mn), SC: O(n)
# At every row consideration, at current cell- we need current cell value, prev cell value and 
# * prev cell's prev iteration calue -- can be stored in a var
class Solution:
    def maximalSquare(self, matrix):
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        maximal = 0
        dp = [0 for i in range(n+1)]
        prev = 0
        for i in range(1,m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == '1':
                    temp = dp[j] # require as we will be changing current cell value- we need to pass this to 'prev'
                    dp[j] = 1 + min(temp, prev, dp[j-1])
                    maximal = max(maximal, dp[j])
                    prev = temp
                else:
                    dp[j] = 0
        return maximal * maximal

        


