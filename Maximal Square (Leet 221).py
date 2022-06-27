'''
Using dp (efficient space)
Time: O(mn)
space: O(n)
'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m = len(matrix)
        n = len(matrix[0])
        res = 0
        
        dp = [0 for x in range(n+1)]
        
        for i in range(1,m+1):
            diag = 0
            for j in range(1, n+1):
                temp = dp[j]
                if matrix[i-1][j-1] == '1':
                    dp[j] = 1 + min(dp[j], dp[j-1], diag)
                    res = max(res, dp[j])
                else:
                    dp[j] = 0
                diag = temp
        return res*res

'''
Using dp
Time: O(mn)
space: O(mn)
'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m = len(matrix)
        n = len(matrix[0])
        res = 0
        
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                    res = max(res, dp[i][j])
        return res*res


'''
Using brute force
(diagonal-down, from there, up and left)
Time: O((mn)^2)
Space: O(1)
'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m = len(matrix)
        n = len(matrix[0])
        res = 0
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    l = 1
                    flag = True
                    while i+l < m and j+l < n and flag == True:
                        for r in range(i+l,i-1,-1):
                            if matrix[r][j+l] == '0':
                                flag = False
                                break
                        
                        for c in range(j+l,j-1,-1):
                            if matrix[i+l][c] == '0':
                                flag = False
                                break
                        
                        if flag == True:
                            l += 1
                    res = max(res, l)
        return res*res