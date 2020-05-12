"""
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        Optimal substructure -> formation of square from coordinates
        Overlapping subproblems -> sub square checks of a bigger square check
        
        Questions
        - How to handle the bigger square (not even number (eg 3x3))
        - 
        Bruteforce Idea - 
        - Initiate flag(square) to be False
        - Consider the single unit of 1 as square of size 1, expand to square of higher size though botton diagonal 
        - Once, bottom diagonal is there, check for 1s in the rows and cols adjoning the diagonal element
        - Break the loop if we encounter a 0
        - if the flag is valid- increment the size
        - Update the max
        - Return max * max
        Complexity - Time - O(m*n)^2 , Space - O(1)
        
        Optimal - Eliminate the re processing of the nested squares
        - Create a table dp of size of matrix.length + 1, matrix[0].length + 1
        - Fill the first row and first col similar to matrix
        - For each cell, update the dp value as min(dp_val,(min of the 3 neighbouring cells + 1))
        
        - return dp[matrix.length][matrix[0].length]

        Complexity - Time - O(m*n), Space - O(m*n)
        """
        
        #Method1
        if not matrix or len(matrix[0]) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        size = 0
        max_val = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    square_flag = True
                    curr = 1
                    # current_row = i + curr
                    # current_col = j + curr
                    while i + curr < m and j + curr < n and square_flag:
                        current_row = i + curr
                        while current_row >=i:
                            if matrix[current_row][j + curr] == '0':
                                square_flag = False
                                break
                            current_row -=1
                        
                        current_col = j + curr
                        while current_col >=j:
                            if matrix[i + curr][current_col] == '0':
                                square_flag = False
                                break
                            current_col -=1
                        
                        if square_flag:
                            curr +=1
                    max_val = max(max_val,curr)
        
        return max_val * max_val
    
        #DP approach
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        max_val = 0
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
                    max_val = max(max_val,dp[i][j])
        return max_val * max_val