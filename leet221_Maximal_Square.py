# Solution

# // Time Complexity : Optimized approach O(m*n)
#                      Time limit exceeded approach O((m*n)^2)
# // Space Complexity : Optimized approach O(m*n)
#                       Time limit exceeded approach O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Optimized approach: We need to start from the last cell of the matrix. Because at any cell, we will be able to tell the max size
# of the matrix the can be made by comparing with all the three values around and below it. [i][j] can be found using min of [i+1][j]
# [i][j+1] and [i+1][j+1]. So min+1 of these three around the main cell tells us the size of matrix that can be created

# Time Limit exceeded approach, for each cell go to the diagonal element, check if it is 1, if it is, then go on the same column
# and row to check if all those cells are 1. If they are then that is the max size right now, we can again go to the next diagonal
# element and check again. This has to be done for each matrix cell.
import math
def maximalSquare(matrix):
    # S30, Optimized O(m*n) time and O(n) space complexity
    m = len(matrix)
    n = len(matrix[0])
    dp = [0 for _ in range(n+1)]
    result = -math.inf
    diagonal = 0
    for i in range(m-1,-1,-1):
        for j in range(n-1,-1,-1):
            if matrix[i][j] == "1":
                temp = dp[j]
                dp[j] = 1 + min(min(dp[j],dp[j+1]),diagonal)
                result = max(result,dp[j])
                diagonal = temp
            else:
                diagonal = dp[j]
                dp[j] = 0
    if result != -math.inf:
        return result*result
    else:
        return 0
    # S30, Optimized O(m*n) time and space complexity
    # m = len(matrix)
    # n = len(matrix[0])
    # dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
    # result = -math.inf
    # for i in range(m-1,-1,-1):
    #     for j in range(n-1,-1,-1):
    #         if matrix[i][j] == "1":
    #             dp[i][j] = 1 + min(min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1])
    #             result = max(result,dp[i][j])
    # if result != -math.inf:
    #     return result*result
    # else:
    #     return 0
    # S30 Time Limit Exceeded solution, O((m*n)^2) time complexity, O(1) space complexity
    # m = len(matrix)
    # n = len(matrix[0])
    # atleast1 = False
    # tempRow = -math.inf
    # tempCol = -math.inf

    # for i in range(m):
    #     for j in range(n):
    #         if matrix[i][j] == "1":
    #             atleast1 = True
    #             row = i
    #             col = j
    #             while row<m-1 and col<n-1:
    #                 row = row+1
    #                 col = col+1

    #                 if matrix[row][col] == "1":
                        
    #                     failed = False
    #                     tempRow1 = row
    #                     while row > i:
    #                         row -= 1

    #                         if matrix[row][col] != "1":
    #                             failed = True
    #                             break
                        
    #                     row = tempRow1

    #                     tempCol1 = col
    #                     while col>j:
    #                         col -= 1

    #                         if matrix[row][col] != "1":
    #                             failed = True
    #                             break
                        
    #                     col = tempCol1

    #                     if failed == True:
    #                         break
    #                     else:
    #                         tempRow = max(tempRow,row - i + 1)
    #                         tempCol = max(tempCol,col - j + 1)
    #                 else:
    #                     break

    # if tempRow != -math.inf and tempCol != -math.inf:
    #     return tempRow*tempCol
    # elif atleast1 == True:
    #     return 1
    # else:
    #     return 0

if __name__ == "__main__":
    matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    print(maximalSquare(matrix))