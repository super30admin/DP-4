class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # DP - BEST - TC - O(m*n) SC - O(m*n)
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        max_len = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                    max_len = max(max_len, dp[i][j])
        return max_len ** 2

    '''
        # Brute Force - more difficult to figure out than dp
        # Time Limit Exceeded 
        # TC - O((n*m)**2)  SC - O(1)
        m, n = len(matrix), len(matrix[0])
        max_len = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == "1":
                    length = 1
                    flag = True
                    while (i+length < m and j+length < n and flag):
                        # rows
                        for k in range(i, i+length+1):
                            if matrix[k][j+length] == "0":
                                flag = False
                                break

                        for k in range(j, j+length+1):
                            if matrix[i+length][k] == "0":
                                flag = False
                                break      
                        if flag:
                            length += 1   
                    max_len = max(max_len, length)
        return max_len*max_len


    '''

