# Brute Force
# Time Complexity: O((mn)*2)
# Space Complexity: O(1)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # Null condition check
        if len(matrix) == 0 or matrix == None:
            return 0
        
        # Declarations
        area = 0
        m = len(matrix)
        n = len(matrix[0])
        
        # Loop through each element in the matrix
        for i in range(m):
            for j in range(n):
                # If the value in the matrix is 1, traverse the diagonal using curr
                # Set the flag to True
                if matrix[i][j] == '1':
                    flag = True
                    curr = 1
                    # Traversing all the elements within the next diagonal
                    while (i + curr < m and j + curr < n and flag):
                        # Column from my diagonal down
                        for k in range(i+curr, i-1, -1):
                            if matrix[k][j+curr] == '0':
                                flag = False
                                break
                        # Row from my diagonal down
                        for k in range(j+curr, j-1, -1):
                            if matrix[i+curr][k] == '0':
                                flag = False
                                break
                        # if flag is true, increment curr and go to next diagonal
                        if flag: 
                            curr += 1
    
                    area = max(area, curr)
        return area * area

# DP solution
# Time Complexity: O(mn)
# Space Complexity: O(mn) 
# Space can be optimized to O(n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # Null condition check
        if len(matrix) == 0 or matrix == None:
            return 0
        
        # Declarations
        length = 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for j in range(n+1)]for i in range(m+1)]
        
        # Start from 1 and traverse the dp matrix to find the max length at each point
        # If the value is 1 in the matrix, take the min of left, up and diag top element
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = min(dp[i][j-1],dp[i-1][j-1],dp[i-1][j]) + 1
                    length = max(length, dp[i][j])
        # Return area
        return length*length
        
        
        