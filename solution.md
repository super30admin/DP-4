# Problem 1: Partition Array for Maximum Sum
## Time Complexity :
O(n*k)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def maxSumAfterPartitioning(self, A: List[int], k: int) -> int:
              #   edge case
              if not A or len(A)==0:
                  return 0

              n = len(A)
              maxSums = [0 for i in range(n)]

                  maxElement = A[i]
                  for j in range(1, k+1):
                      if (i - j + 1 >= 0):
                          maxElement = max(maxElement, A[i - j + 1])

                          if (i - j >= 0):
                              currentSum = (j * maxElement) + maxSums[i - j]
                          else:
                              currentSum = (j * maxElement) + 0

                          maxSums[i] = max(maxSums[i], currentSum)

              return maxSums[n - 1] 
              
# Problem 2: Maximal Square
## Time Complexity :
O(n*m)

## Space Complexity :
O(n*m)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def maximalSquare(self, matrix: List[List[str]]) -> int:
              #   edge case
              if not matrix or len(matrix) == 0:
                  return 0

              rows = len(matrix)
              cols = len(matrix[0])
              dp = [ [0 for c in range(cols)] for r in range(rows) ]
              maxSoFar = 0

              for col in range(cols):
                  dp[0][col] = int(matrix[0][col])
                  maxSoFar = max(maxSoFar, dp[0][col])

              for row in range(rows):
                  dp[row][0] = int(matrix[row][0])
                  maxSoFar = max(maxSoFar, dp[row][0])

              for r in range(1, rows):
                  for c in range(1, cols):
                      if (matrix[r][c] == '0'):
                          dp[r][c] = 0
                      else:
                          dp[r][c] = 1 + min(dp[r][c-1], dp[r-1][c], dp[r-1][c-1])
                          maxSoFar = max(maxSoFar, dp[r][c])

              return (maxSoFar * maxSoFar)
