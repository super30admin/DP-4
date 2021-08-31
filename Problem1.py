# Time Complexity : O(mn^2) where m is the number of rows and n is the number of columns
# Space Complexity : O(1)

# Brute Force Approach
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxi = 0
        #Iterate over each and every Element
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    #if 1 is found, set flag as true
                    flag = True
                    curr = 1
                    while i+curr < m and j+curr < n and flag:
                        #Check column from diagonal down
                        for k in range(i+curr,i-1,-1):
                            if matrix[k][j+curr] == '0':
                                flag = False
                                break
                        #Check row from diagonal down
                        for k in range(j+curr,j-1,-1):
                            if matrix[i+curr][k] == '0':
                                flag = False
                                break
                        if flag:
                            #If flag is true, it means that 0 was not found 
                            curr += 1
                    maxi = max(maxi, curr)
        return maxi * maxi

# Approach 2

# Time Complexity : O(mn) where m is the number of rows and n is the number of columns
# Space Complexity : O(mn)

#At every node, we are forming what is the maximal length square at that index
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxi = 0
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i][j-1], min(dp[i-1][j], dp[i-1][j-1])) +1
                    maxi = max(maxi, dp[i][j])
        return maxi * maxi 