# DP solution
# Time O(n*m)
# Space O(1)
import math
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n, m = len(matrix), len(matrix[0])
        top, diag, side = 0, 0, 0
        maxSq = 0
        for i in range(0, n):
            for j in range(m):
                if matrix[i][j] == "1":
                    if i-1 >= 0:
                        top = matrix[i-1][j]
                        if j-1 >= 0: diag = matrix[i-1][j-1]
                    if j-1 >= 0: side = matrix[i][j-1]
                    matrix[i][j] = min(top, diag, side) + 1
                    maxSq = max(maxSq, matrix[i][j])
                    top, diag, side = 0, 0, 0
                else: matrix[i][j] = 0
        return maxSq * maxSq


# Brut force solution
# Time O((n*m)*(n*m))
# Space O(1)
import math
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n, m = len(matrix), len(matrix[0])
        maxSq = 0
        for i in range(0, n):
            for j in range(m):
                if matrix[i][j] == "1":
                    l = 1
                    maxSq = max(maxSq, l)
                    flag= True
                    while flag and i+l < n and j+l < m:
                        x = i
                        #if i+l == n or j+l == m: break
                        while x < i+l+1 and x < n:
                            y = j
                            while y < j+l+1 and y < m:
                                if matrix[x][y] == "0": 
                                    flag = False
                                    break
                                y += 1
                            if not flag: break
                            x += 1
                    
                        if flag: 
                            maxSq = max(maxSq, l+1)
                            l += 1

        return maxSq * maxSq

        

        