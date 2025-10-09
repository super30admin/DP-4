#  Time Complexity : O(m * n) where m is the number of rows and n is the number of columns in the matrix 
#  Space Complexity : O(n) where n is the number of columns in the amtrix 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : We start from right bottom corner of the matrix and move to the top left corner. We keep a track of the maximum number of squares we can form at each index. We use a DP array to store the maximum number of squares that can be formed at each index. We update the DP array as we move from bottom to top and right to left.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int: #Here we use Dynammic Programming as we have a repeated subproblem. As we consider 2 * 2 squares, we will face a repeated subproblem of finding the max value of the squares. 
        m = len(matrix)
        n = len(matrix[0])
        dp = [0] * (n + 1)  # We will conisder a DP array of length n + 1 where n is the no of columns of the matrix,  
        maxVal = 0

        for i in range (m - 1, -1, -1):
            diagDown = 0
            for j in range(n - 1, -1, -1):
                temp = dp[j]  #We are storing the previous dp[j] in the temp variable. We are doing this as we are overwriting the current row with the previous row. So in this case the previous to the previous dp[j] acts as the diagonaldown element for the current dp[j] 
                if(matrix[i][j] == "1"):
                    dp[j] = 1 + min(dp[j], min(dp[j + 1], diagDown)) #Here we find the min of the bottom element, right side element and the diagonal down element and add 1 to it    
                    maxVal = max(maxVal, dp[j]) # We keep a track of the maximum number of squares
                else:
                    dp[j] = 0
                
                diagDown = temp
        
        return maxVal * maxVal  #Return the area of the maximum number of squares