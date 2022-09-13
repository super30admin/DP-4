# Time complexity : O(m*n)
# Space complexity : O(m*n)
# Leetcode : Solved and submitted

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        
        # calculate rows and cols of the matrix
        rows = len(matrix)
        cols = len(matrix[0])
        
        # to maintain the max value
        max_val = 0
        
        # check in the first row if we have a 1, then max is 1
        for i in range(rows):
            if matrix[i][0] == '1':
                max_val = 1
        
        # check in the first col if we have a 1, then max is 1
        for i in range(cols):
            if matrix[0][i] == '1':
                max_val = 1
        
        
        # creating a dp array which is of size rows + 1 and cols + 1 of the original matrix
        dp = [[0 for _ in range(cols+1)] for _ in range(rows+1)]
        
        # traversing over the matrix, we only check for 3 elements, left, up and the diagonal on the upper left
        # we maintain the max sqaures seen so far in linear time
        for i in range(1,rows+1):
            for j in range(1,cols+1):
                # if element is 1, then get the min of 3 neighbors and add one to it
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = 1 + min(dp[i-1][j], min(dp[i][j-1],dp[i-1][j-1]))
                    
                    # update the max if it changed
                    max_val = max(max_val,dp[i][j])
        
        # return square of the max value
        return max_val * max_val
