# A taught in class, checking the minimum in all 3 direections in matrix and adding one to analyse the repeating subproblems
#Time complexity: O(m*n)
#Space Complexity: O(m*n)
matrix = [[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]
def dpMat(matrix):
    dp = [[0]*(len(matrix[0])+1)]*(len(matrix)+1)
    maxi = 0
    print(dp)
    for i in range(1,len(dp)-1):
        for j in range(1,len(dp[0])-1):
            if matrix[i-1][j-1] == 1:
                dp[i][j] = min(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]) +1
                maxi = max(maxi,dp[i][j])
    return maxi*maxi

m = dpMat(matrix)
print(m)