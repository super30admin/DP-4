# Brute Force
# Time Complexity: O((m*n)^2)
# Space Complexity: O(1)
# Approach: Traverse over the matrix. For every "1", explore the next layer of elements that can form a square (diagonal, right, down). At any point if you encounter a zero, break.

class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        rows = len(matrix)
        cols = len(matrix[0])
        maxlen = 0
        
        # Traverse over matrix
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == "1":
                    # curr tracks the size of the square
                    curr = 1
                    flag = True
                    # Check if i, j are within bounds
                    while(i + curr < rows and j + curr < cols and flag):
                        for k in range(i, i+curr+1): # Check element to right and diagonal
                            if matrix[k][j+curr] == "0":
                                flag = False
                                break
                        for k in range(j, j+curr+1): # Check element down and diagonal
                            if matrix[i+curr][k] == "0":
                                flag = False
                                break
                        # Increase layer size
                        if flag == True:
                            curr += 1

                    maxlen = max(maxlen, curr)
                    
        return maxlen * maxlen
