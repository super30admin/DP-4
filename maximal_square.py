# Time Complexity :
# O(MN)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We go through each element in the matrix and compute what is the largest square of 1s that can be formed until then. 
#Then at each point, if the value is not 0, we check min of value on the left, above and diagonally left and pick the minimum among them - that is the maximum size of square that can be formed from the current position, we update the matrix and move ahead
#We do this until the end, and find the maximum value in the matrix and return it's square value

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        max_val = 0

        for i in range(1,n):
            for j in range(1,m):
                if matrix[i][j] != '0' :
                    neighbours = [int(matrix[i-1][j-1]),int(matrix[i][j-1]),int(matrix[i-1][j])]
                    best_value = min(neighbours) + 1
                    matrix[i][j] = str(best_value)

        for i in range(0,n):
            for j in range(0,m):
                max_val = max(max_val,int(matrix[i][j]))

        return max_val*max_val
