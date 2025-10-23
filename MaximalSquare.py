class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # since we need to exlpore each node and expand from there to see whats the larget possible square possible, using a bruste force will take O(n2m2)
        # we can use dp and store the max square possible in the neighbor cells and take min of all 3 as we need sqaure and add 1 for contribution of current cell
        # as for dp two approches: one is start from top right traversal and have a helper recurssive function which recrussively finds the max square possibel for their neighbors ( right, bottom, right-bottom)
        # this recurrive and hashmap solution : tc : O(nm) sc: O(n+m) recrussive stack space + O(nm) the hashmap space
        
        # optimal approach : each cell's value depends on its right, bottom, and bottom-right (diagonal) neighbors. 
        # By iterating backward, we ensure those neighboring cells are already computed, 
        # allowing us to efficiently calculate the largest square ending at the current cell., tc: O(nm), sc : O(nm)

        m = len(matrix)
        n = len(matrix[0])
        max_square = 0


        dp = [0] * (n + 1) 
        diagup = 0

        for i in range(1,m+1):
            for j in range(1,n+1):
                temp = dp[j]
                if matrix[i-1][j-1] == '1':
                    dp[j] = 1 + min(dp[j], dp[j-1], diagup)
                    max_square = max(max_square,dp[j])
                else :
                    dp[j] = 0
                diagup = temp


        return max_square*max_square # return area
        
        