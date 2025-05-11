'''

Tricky, I almost copy pasted solution from the Instructor solution.

The key part is you go to the diagonal and make sure that the left side and right side of the diagonal contains all 1's.

And you proceed to keep adding length until you find the max.

Initially stuck keeping the le value and max value, but finally found the spot after iterating through it.

The entire core of the problem lies with the explanation, you build bottom up solution by taking the min of the neighbors, and make sure to build the max when needed!

And also another key point is when you are building the dp matrix, you create one extra row and one extra low to calculate the value for the last row and last col.


Time complexity = O(m*n)
Space Complexity = O(m*n)

'''

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0 for j in range(cols + 1)] for i in range(rows + 1)]

        m_len = 0

        for i in range(rows-1, -1,-1):
            for j in range(cols-1,-1,-1):
                if(matrix[i][j]=='1'):
                    dp[i][j] = 1+min(dp[i+1][j+1], dp[i+1][j], dp[i][j+1])
                    m_len = max(m_len, dp[i][j])


        return m_len*m_len



