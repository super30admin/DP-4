# // Time Complexity : O(mn) 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Method 1: T(n): O(mn), Space = O(1) => DP soln
# use same matrix
# if number is 1 we update it with the 1+ min(laft, up, diagonaly left up) 
# we keep track of maximum in a var
# 
# Method 2: O(mn)^2
# We iterate through the matrix
# for each 1 we found we go diagonally down and check col and row 
# if col and row contains 1 we break
# else we move down more updating the max variable


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if len(matrix) == 0 or matrix == None : return 0
        
        m = len(matrix)
        n = len(matrix[0])
        maximum = 0
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i][j] == "1":
                    matrix[i][j] = 1 + min(int(matrix[i-1][j]), int(matrix[i][j-1]),int(matrix[i-1][j-1]))
                    maximum = max(maximum, matrix[i][j])
        if maximum == 0:
            for i in matrix:
                if "1" in i or 1 in i:
                    maximum = 1
        return maximum**2
    
                   
        
#         m = len(matrix)
#         n = len(matrix[0])
#         maximum = 0
#         flag = True
        
#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j] == "1":
#                     flag = True
#                     cur = 1
                    
#                     while i+cur<m and j+cur<n and flag:
#                         # look up in the column for 1
#                         for k in range(i+cur, i-1, -1):
#                             if matrix[k][j+cur] == "0":
#                                 flag = False
#                                 break
            
#                         for k in range(j+cur, j-1, -1):
#                             if matrix[i+cur][k] == "0":
#                                 flag = False
#                                 break
#                         if flag:
#                             cur += 1
                    
#                     maximum = max(maximum, cur)


#         return (maximum)**2
            
                        
        
        