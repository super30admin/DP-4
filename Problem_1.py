'''
221 Maximal Square
https://leetcode.com/problems/maximal-square/description/

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

Solution:
1. Brute Force
We go through every cell and when we hit a '1', we try to expand a square from there. For each expansion, we check the new bottom row and right column to ensure they're all '1'. We keep track of the largest square we can build and return its area.
https://youtu.be/C-wjwRek6K0?t=236
Time: O((MN)^2), Space: O(1)

2. DP 1
We use dp to fill a matrix with the largest square size ending at each cell.
For every '1' in matrix, we read the left, top, and (left) diagonal to get dp value as dp[i][j] = 1 + min(mat[i][j-1], mat[i-1][j], mat[i-1][j-1]) to get  the biggest square possible at mat[i][j]. We do this from top-left to bottom-right to ensure all dependencies are already filled.
https://youtu.be/C-wjwRek6K0?t=1914
Time: O(MN), Space: O(MN)

3. DP 2
This is similar to DP 1 but it uses a 1-D array, instead of a matrix, to store the DP values
https://youtu.be/C-wjwRek6K0?t=3022
Time: O(MN), Space: O(N)


'''
def maximalSquare_BruteForce(matrix):
    def is_valid_square(x, y, i, j):
        col = y
        valid = True
        for row in range(x,i-1,-1):
            if matrix[row][col] != '1':
                valid = False
                break
        row = x
        if valid:
            for col in range(y,j-1,-1):
                if matrix[row][col] != '1':
                    valid = False
                    break
        return valid

    if not matrix:
        return 0
    M = len(matrix)
    N = len(matrix[0])
    max_area = 0
    for i in range(M):
        for j in range(N):
            x, y = i, j
            count = 0
            while x < M and y < N and matrix[x][y] == '1':
                if is_valid_square(x, y, i, j):
                    count += 1
                    x += 1
                    y += 1
                else:
                    break
            max_area = max(count*count, max_area)
    return max_area

def maximalSquare_DP1(matrix):
    if not matrix:
        return 0
    M = len(matrix)
    N = len(matrix[0])
    dp = [ [0]*(N+1) for _ in range(M+1)]
    max_area = 0
    for i in range(1,M+1):
        for j in range(1,N+1):
            if matrix[i-1][j-1] == '1':
               top = dp[i-1][j]
               left = dp[i][j-1]
               diag = dp[i-1][j-1]
               dp[i][j] = min(top, left, diag) + 1
               max_area = max(dp[i][j]*dp[i][j], max_area)
    return max_area

def maximalSquare_DP2(matrix):
    if not matrix:
        return 0
    M = len(matrix)
    N = len(matrix[0])
    dp = [0]*(N+1)
    max_area = 0
    diag = dp[0]
    for i in range(1,M+1):
        for j in range(1,N+1):
            prev = dp[j] # save diag for computing next dp value (dp[j+1])
            top =  dp[j] # top for dp[j]
            left = dp[j-1]
            if matrix[i-1][j-1] == '1':
                dp[j] = 1 + min(left, top, diag)
                max_area = max(dp[j]*dp[j], max_area)
            else:
               dp[j] = 0
            diag = prev # retrieve diag for next dp value (dp[j+1])
    return max_area

def run_maximalSquare():
    tests = [ ([["1","0","1","0","0"],
                ["1","0","1","1","1"],
                ["1","1","1","1","1"],
                ["1","0","0","1","0"]], 4),
              ([["1","0","1","0","0"],
                ["1","0","1","1","1"],
                ["1","1","1","1","1"],
                ["1","0","1","1","1"]], 9),
              ([["0","1"],["1","0"]], 1),
              ([["0"]], 0),
              ([["1","1","1","1","0"],
                ["1","1","1","1","0"],
                ["1","1","1","1","1"],
                ["1","1","1","1","1"],
                ["0","0","1","1","1"]], 16), # for all other cases, dp[i][j] = diag + 1 will work. For this case, diag + 1 doesn't work. This case tells why the logic 'min(top, diag, left) + 1' is correct instead of 'daig + 1'
    ]
    for test in tests:
        matrix, ans = test[0], test[1]
        print(f"\nmatrix = {matrix}")
        for method in ['brute-force', 'dp1', 'dp2']:
            if method == "brute-force":
               area = maximalSquare_BruteForce(matrix)
            elif method == "dp1":
                area = maximalSquare_DP1(matrix)
            elif method == "dp2":
                area = maximalSquare_DP2(matrix)
            print(f"Method {method}: Maximal Area = {area}")
            success = (ans == area)
            print(f"Pass: {success}")
            if not success:
                print(f"Failed")
                return

run_maximalSquare()
