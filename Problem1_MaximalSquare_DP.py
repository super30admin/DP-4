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
# O( (M*N) ) - Where M is the number of rows and N is no. of columns in input

#------------------
# Space Complexity: 
#------------------
# O(N): Where N is the number of cols.

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
        
        dp = [0 for j in range(n+1)]
        
        #diagonal up-left element
        diag = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == "1":
                    temp = dp[j]
                    dp[j] = min(dp[j-1], dp[j], diag) + 1
                    max_val = max(max_val, dp[j])
                    diag = temp
                else:
                    dp[j] = 0
                
        
        return max_val**2
                        
                    
                        
                    