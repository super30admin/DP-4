"""
Approach: Bruteforce

Example:
[["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]]
 
In the above example we will traverse every cell and do the following:
1) Check if the current cell has 1. 
2) If yes then traverse diagonally down and from there traverse up and left checking for 1. If 0 is found then its not square
Ex: 1 0 1
    1 1 0
    0 1 1
    
above we traverse diagonally to m[1][1] then check if m[0][1] and m[1][0] has 1. If yes then it makes it a sqaure else it does not.

TC: O(mn)^2
SC: O(1)
"""

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])
        maxi = 0
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == "1":
                    isSquare = True
                    curr = 1
                    while i + curr < m and j + curr < n and isSquare:
                        #check column (we are going down here which is also valid)
                        for k in range(i, i+curr+1):
                            if matrix[k][j + curr] == "0":
                                isSquare = False
                                break
                                
                        # check row (we are going right here which is also valid)
                        for k in range(j, j+curr+1):
                            if matrix[i + curr][k] == "0":
                                isSquare = False
                                break
                        
                        if isSquare:
                            curr += 1
                            
                    maxi = max(maxi, curr)
                    
                    
        return maxi * maxi
    
"""
Approach: DP

We initialize another matrix (dp) with the same dimensions as the original one initialized with all 0’s.

dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell with index (i,j) in the original matrix.

Starting from index (0,0), for every 1 found in the original matrix, we update the value of the current element as

dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1.

We also remember the size of the largest square found so far. In this way, we traverse the original matrix once and find out the required maximum size. This gives the side length of the square (say maxsqlen). The required result is the area maxsqlen^2 .

TC: O(m x n)
SC: O(m x n)
"""   
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0    
                        
        maxi = 0
        m = len(matrix)
        n = len(matrix[0])
        
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1
                    maxi = max(maxi, dp[i][j])
        
        return maxi * maxi