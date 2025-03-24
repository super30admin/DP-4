# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach

class BottomUpSolution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        R = len(matrix)
        C = len(matrix[0])
        
        res = 0
        
        if R == 0: return 0

        dp = [[0] * C for i in range(R)]

        for j in range(C):
            dp[R-1][j] = int(matrix[R-1][j])
            res = max(res, dp[R-1][j])
        
        for i in range(R):
            dp[i][C-1] = int(matrix[i][C-1])
            res = max(res, dp[i][C-1])

        r,c = R - 2, C - 2

        while r >= 0:
            c = C-2
            while c >= 0:
                if matrix[r][c] == "1":
                    dp[r][c] = min(dp[r+1][c], dp[r][c+1], dp[r+1][c+1]) + 1
                    res = max(res, dp[r][c])
                c -= 1
            r -= 1

        return res * res

# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach

class TopDownSolution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        R = len(matrix)
        C = len(matrix[0])

        memo = [[-1] * C for i in range(R)]

        def recurse(r,c):
            # base
            if r == R-1 or c == C-1:
                return int(matrix[r][c])
            if matrix[r][c] == "0":
                return 0
            if memo[r][c] != -1:
                return memo[r][c]
            
            # logic
            right = recurse(r,c+1)
            down = recurse(r+1,c)
            diag = recurse(r+1, c+1)

            memo[r][c] = 1 + min(right, down, diag)

            return memo[r][c]

        max_res = 0
        for i in range(R):
            for j in range(C):
                if matrix[i][j] == "1":
                    max_res = max(recurse(i,j), max_res)
        
        return max_res * max_res