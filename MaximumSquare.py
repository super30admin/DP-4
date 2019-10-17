"""
A simple approach to this problem is to check at every index if we could form a square, the condition
for that should be that all the sides above the index i.e left,right and diagnal should be 1. if so we
make the current index to 1 in the dp array, like this we traverse the whole array and at point in the
the index we search for the minimum element amoungst all the three sides, if there is a min value of 1
this means a square cannot be formed and we move without doing anything, lastly we return the max value 
the dp array. 
Leetcode - Running
Time complexity - O(N)
Space complexity - O(N)

"""
def maximalSquare(self, matrix):
    row = len(matrix)
    if row == 0:
        return 0
    column = len(matrix[0])
    dp = [[1 if ch == '1' else 0 for ch in r] for r in matrix]
    for i in range(1,row):
        for j in range(1,column):
            if matrix[i][j] == '1':
                dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
                
                
    return max(max(row) for row in dp) ** 2                   
