class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:


        ## approach 2
        ## T.C = O(m.n)
        ## S.C = O(m.n)

        ROWS = len(matrix)
        COLS = len(matrix[0])
        dp = []
        mx = 0
        for i in range(ROWS + 1):
            tmp = []
            for j in range(COLS + 1):
                tmp.append(0)
            dp.append(tmp)

        for i in range(1, ROWS+1):
            for j in range(1, COLS+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
                    mx = max(mx, dp[i][j])
        
        print(dp)
        return mx*mx

        ## approach 1: brute force
        ROWS = len(matrix)
        COLS = len(matrix[0])
        mx = 0

        for i in range(ROWS):
            for j in range(COLS):

                if matrix[i][j] == '1':
                    diag = 0
                    flag = True
                    
                    while flag and (i + diag) in range(ROWS) and (j+diag) in range(COLS):
                        
                        for k in range(i + diag, i-1, -1):
                            if matrix[k][j+diag] == '0':
                                flag = False
                        
                        for k in range(j + diag, j-1, -1):
                            if matrix[i+diag][k] == '0':
                                flag = False
                        
                        if flag:
                            diag += 1
                    
                    mx = max(mx, diag)
        
        return mx * mx
                    










