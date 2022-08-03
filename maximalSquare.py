# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:

	def maximalSquare(self, lst: List[List[str]]) -> int:
		n, m = len(lst), len(lst[0])
		dp = [[0 for j in range(m)] for i in range(n)]
		maxi = 0
		for i in range(n - 1, -1, -1):
			for j in range(m - 1, -1, -1):

				if lst[i][j] == "0":
					dp[i][j] = 0
				elif i == n - 1:
					dp[i][j] = int(lst[i][j])
				elif j == m - 1:
					dp[i][j] = int(lst[i][j])
				else:
					dp[i][j] = 1 + min(dp[i + 1][j + 1], dp[i + 1][j], dp[i][j + 1])

				if dp[i][j] > maxi:
					maxi = dp[i][j]

		return maxi * maxi
