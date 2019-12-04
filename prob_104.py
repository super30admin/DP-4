# leetcode 221
# time  - size of square
# space - o(1)
#brute force
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # variables

        rows = len(matrix)  # calculate number of rows
        if rows == 0:  # edge case
            return 0
        cols = len(matrix[0])

        boolean_flag = False  # flag to check for zero
        Max_sqr = 0   #square of length Max_sqr
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    boolean_flag = True
                    curr = 1
                    # check for ith and jth lcoation of window diagnal
                    while i + curr < rows and j + curr < cols and boolean_flag:  # so as to not to overshoot
                        for k in range(i + curr, i - 1, -1):
                            if (matrix[k][j + curr] == '0'):  # j+curr is the column that is to be checked
                                boolean_flag = False
                                break;
                        for k in range(j + curr, j - 1, -1):  # for the row i and till col j is reached
                            if (matrix[i + curr][k] == '0'):  # i+curr is the row that is to be checked
                                boolean_flag = False
                                break;
                        if boolean_flag:
                            curr += 1
                    Max_sqr = max(Max_sqr, curr)
        return Max_sqr * Max_sqr #return number of elements in square


#Only few test cases passed for this sol
# leetcode 221
# time  - size of square
# space - o(1)
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        # variables

        rows = len(matrix)  # calculate number of rows
        if rows == 0:  # edge case
            return 0
        cols = len(matrix[0])
        Max_sqr = 0  # square of length Max_sqr
        dp = [[0 for i in range(cols + 1)] for j in range(rows + 1)]
        # logic
        for i in range(1, len(dp), 1):
            for j in range(1, len(dp[0]), 1):
                if matrix[i - 1][
                    j - 1] == '1':  # since we are moving down, whenever we enecounter and element other than zero will be 1
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - i]) + 1
                    Max_sqr = max(Max_sqr, dp[i][j])

        # Max_sqr = max(Max_sqr,curr)
        return Max_sqr * Max_sqr  # return number of elements in square






















