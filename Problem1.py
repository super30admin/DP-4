# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# if top,left and diagonal left is 1 then if present element is 1 then square existed
# that implies there exists a square of size greater than equal to 2 using the same
# logic to save the previous square sizes in the left,top and diagonal top left and add 1
# to count the size and keep track of the max value then return max value


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m = len(matrix)
        n = len(matrix[0])
        maxVal = 0
        for i in range(0,m):
            for j in range(0,n):
                if i == 0 or j == 0:
                    matrix[i][j] = int(matrix[i][j])
                if matrix[i][j] == "0":
                    matrix[i][j] = int(matrix[i][j])
                if matrix[i][j] == "1":
                    matrix[i][j] = min(matrix[i][j-1],matrix[i-1][j-1],matrix[i-1][j]) + 1
                    
                maxVal = max(maxVal,matrix[i][j])
        return maxVal*maxVal