# tc O(m * n), sc O(n).
ROWS, COLUMNS = len(matrix), len(matrix[0])
dp = [0 for _ in range(COLUMNS)]
maxarea = 0

for column in range(COLUMNS):
    if matrix[0][column] == "1":
        dp[column] = 1
        maxarea = max(maxarea, dp[column])

for row in range(1, ROWS):
    for column in range(COLUMNS):
        temp = dp[column] 
        if matrix[row][column] == "1":
            if column == 0:
                dp[0] = 1
            else:
                dp[column] = 1 + min(dp[column-1], dp[column], topleft)
            maxarea = max(maxarea, dp[column])
        else:
            dp[column] = 0
        topleft = temp

return maxarea * maxarea