class Solution(object):
    #optimise on space by using 1d array and diag down var
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or len(matrix) == 0: 
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxx = 0
        dp = [0 for _ in range(n+1)]
        diagdown = 0
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if matrix[i][j] == "1":
                    temp = dp[j]
                    dp[j] = min(dp[j+1],min(dp[j], diagdown))+1
                    maxx = max(maxx,dp[j])
                    diagdown = temp
                else:
                    dp[j] = 0
        return maxx*maxx
    #Identified repeated subproblem
    #can be done using DP
    #freeze last row and last col
    #From right hand bottom corner diagnoal , if we see a 1 - take minimum of all three sides and add 1 to it
    #TC : O(nxm)
    # SC: O(nxm)
    #def maximalSquare(self, matrix):
        """
        #:type matrix: List[List[str]]
        #:rtype: int
        if not matrix or len(matrix) == 0: 
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxx = 0
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if matrix[i][j] == "1":
                    dp[i][j] = min(dp[i+1][j+1],min(dp[i+1][j], dp[i][j+1]))+1
                    maxx = max(maxx,dp[i][j])
        return maxx*maxx
        #TC : O(mxn)(mxn)
        #SC: O(1)
        if not matrix or len(matrix) == 0: 
            return 0
        m = len(matrix)
        n = len(matrix[0])
        maxx = 0
        for i in range(m):
            for j in range(n):
                if (matrix[i][j] == "1"):
                    flag = True
                    le = 1
                    while(i + le < m and j + le <n and flag):
                        #same col upto index 1
                        for k in range(i+le,i-1,-1):
                            if matrix[k][j+le] == "0":
                                flag = False
                                break
                        #same row upto index 1
                        for k in range(j+le,j-1,-1):
                            if matrix[i+le][k] == "0":
                                flag = False
                                break
                        if flag:
                            le+=1
                    maxx = max(maxx,le)

        return maxx*maxx
        """

