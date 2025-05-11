# Time Complexity: O(m*n)
# Space Complexity: O(n)
# Approach: Dynamic Programming
# We can use a 1D array to store the maximum square length at each cell.
# This is to optimize on the space complexity of the 2D array.
# At each cell, we can check the maximum square length that can be formed by checking the left, top and diagonal cells.
# The maximum square length at each cell is the minimum of the three cells plus 1.
# The result is the maximum square length found in the 1D array.
class Solution:
    def maximalSquare(self, matrix):
        # Caculate the number of rows and columns
        m = len(matrix)
        n = len(matrix[0])
        # Initialize a 1D array to store the maximum square length at each cell
        dp = [0 for _ in range(n+1)]
        # Initialize the result to 0
        res = 0
        # Initialize a variable to store the diagonal value
        # This is because at each cell, we will have replaced the value of the diagonal cell with the maximum square length
        # So we need to store the previous diagonal value to use it in the next iteration
        diagUp = 0

        # Iterate through the matrix
        # We start from 1 because 1st row will remain the same. We cannot calculate the maximum square length at the first row.
        for i in range(1, m+1):
            # Iterate through the columns of the current row
            # We start from 1 because we have added an extra column to the dp array
            for j in range(1, n+1):
                # Store the current value of the diagonal cell
                tmp = dp[j]
                # Check if the current cell is '1'
                if matrix[i-1][j-1] == '1':
                    # If it is, calculate the maximum square length at the current cell
                    dp[j] = 1 +  min(dp[j-1], dp[j], diagUp)
                    # Update the diagonal value to the current cell
                    res = max(res, dp[j])
                # If it is not, set the maximum square length at the current cell to 0
                else:
                    dp[j] = 0
                # Update the diagonal value to the previous diagonal value
                diagUp = tmp
        # Return the maximum square length found in the 1D array
        return res * res

# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Approach: Dynamic Programming
# We use a 2D array to store the maximum square length at each cell.
# At each cell, we can check the maximum square length that can be formed by checking the left, top and diagonal cells.
# The maximum square length at each cell is the minimum of the three cells plus 1.
# The result is the maximum square length found in the 2D array.
class Solution:
    def maximalSquare(self, matrix):
        # Calculate the number of rows and columns
        m = len(matrix)
        n = len(matrix[0])
        # Initialize a 2D array to store the maximum square length at each cell
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        # Initialize the result to 0
        res = 0
        # Iterate through the matrix
        # We start from 1, because we added an extra row and column to the dp array
        for i in range(1, m+1):
            for j in range(1, n+1):
                # Check if the current cell is '1'
                if matrix[i-1][j-1] == '1':
                    # If it is, calculate the maximum square length at the current cell
                    # Store the maximum square length at the current cell
                    dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
                    # Update the result to the maximum square length found so far
                    res = max(res, dp[i][j])
        # Return the maximum square length found in the 2D array
        return res * res
    
# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Approach: Dynamic Programming
# This approach is the same as above, however, we iterate through the matrix in reverse order.
class Solution:
    def maximalSquare(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        res = 0

        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m-1 or j == n-1:
                    print(i, j)
                    dp[i][j] = int(matrix[i][j])
                elif matrix[i][j] == '1':
                    dp[i][j] = 1 + min(dp[i][j+1], dp[i+1][j], dp[i+1][j+1])
                    res = max(res, dp[i][j])

        for i in range(m):
            for j in range(n):
                res = max(res, dp[i][j])
        return res * res

# This is an m^2 * n^2 solution
# Here, we observe repeated sub-problems, when checking if a square can be formed and expanded.
# When we do this, we might come acress a square that has already been checked, as part of another bigger square.
class Solution:
    def maximalSquare(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        res = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    le = 1
                    flag = True
                    while i+le < m and j+le < n:
                        for k in range(j+le, j, -1):
                            if matrix[i+le][k] == '0':
                                flag = False
                                break
                        for k in range(i+le, i, -1):
                            if matrix[k][j+le] == '0':
                                flag = False
                                break
                        if flag:
                            le += 1
                    res = max(res, le)
        return res*res