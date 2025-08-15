# Time Complexity: O(m*n)
# Space Complexity: O(n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        dp = [0] * (n + 1)
        max_val = 0
        temp = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                prev = dp[j]
                print(dp)
                if matrix[i - 1][j - 1] == '1':
                    dp[j] = 1 + min(dp[j - 1], min(dp[j], temp))
                    print('i: ', i, 'j: ', j)
                    print('dp:', dp)
                    max_val = max(max_val, dp[j])

                else:
                    dp[j] = 0
                temp = prev
                print('temp:', temp)

        return max_val * max_val

