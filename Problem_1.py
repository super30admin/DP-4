'''
Time Complexity - O(m2n2) for Brute force, O(mn) for DP approach
Space Complexity - O(1) for Brute Force, O(mn) for DP approach

Works on Leetcode
'''
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        #BRUTE FORCE TLE
        m, n, maxL = len(matrix), len(matrix[0]), 0
        # for i in range(m):
        #     for j in range(n):                #check each element in the matrix
        #         if matrix[i][j] == "1": # if the element is 1, it is a square of size 1
        #             l = 1
        #             flag = True
        #             while i+l<m and j+l<n and flag: #expand the square unit, maintain its properties
        #                 for k in range(i+l,i-1,-1): #check the incoming elements that are getting contained
        #                     if matrix[k][j+l] == "0": # if any element is 0, a square of size l is not possible
        #                         break
        #                 for k in range(j+l, j-1, -1):
        #                     if matrix[i+l][k]=="0":
        #                         flag = False
        #                         break
        #                 if flag:
        #                     l+=1
        #             maxL = max(l, maxL) #check if l is max
        # return maxL*maxL #we return the area i.e (maxSize) ^ 2
        dp = [[0 for j in range(n+1)] for i in range(m+1)] #create a DP array
        for i in range(1, m+1):
            for j in range(1, n+1): #we iterate each element in the matrix
                if matrix[i-1][j-1] != "0":
                    dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) #for max square size at every element is 1 + minimum size of left, up, left diagonal above square.
                maxL = max(maxL, dp[i][j]) #check if the square size is max
        return maxL*maxL #return the area
        