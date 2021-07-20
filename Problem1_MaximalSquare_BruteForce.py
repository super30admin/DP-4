'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 221. Maximal Square

# https://leetcode.com/problems/maximal-square/

#-----------------
# Time Complexity: 
#-----------------
# O( (M*N) ^ 2) - Where M is the number of rows and N is no. of columns in input

#------------------
# Space Complexity: 
#------------------
# O(1): Constant space for temporary variable

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        if m > 0:
            n = len(matrix[0])
        else:
            n = 0
        
        max_val = 0
        
        for i in range(m):
            for j in range(n):
                flag = False
                if matrix[i][j] == "1":
                    flag = True
                    
                    #length of side of square
                    curr = 1
                    
                    while i + curr < m and j + curr < n:
                        
                        #column check
                        for k in range(i+curr, i-1, -1):
                            if matrix[k][j + curr] == "0":
                                flag = False
                                break

                        #row check
                        for k in range(j+curr, j-1, -1):
                            if matrix[i+curr][k] == "0":
                                flag = False
                                break
                        if flag:
                            curr += 1
                        else:
                            break
                    
                    max_val = max(max_val, curr)
        
        return max_val**2
                        
                    