#Time Complexity : O(n*m) where n is number of elemets in rows and m is number of elemets in columns
#Sapce Complexity :  O(n*m) where n is number of elemets in rows and m is number of elemets in columns
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix)==0:
            return 0 
        n = len(matrix)
        m = len(matrix[0])
        dp = [[0 for x in range (m+1) ] for y in range (n+1)]
        max1 = 0
        for i in range(1,len(dp)):
            for j in range (1,len(dp[0])):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = 1 + min((dp[i][j-1],dp[i-1][j],dp[i-1][j-1]))
                    max1 = max(max1,int(dp[i][j]))
                 
        return max1**2
============================================
        