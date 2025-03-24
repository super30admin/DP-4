'''
    Time Complexity: O(nk)
    Space Complexity: O(n)
'''
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0 for _ in range(n)]
        dp[0] = arr[0]

        for i in range(1, n):
            curMax = arr[i]
            
            for j in range(1, k+1):
                if i - j + 1 < 0:
                    break
                else:
                    curMax = max(curMax, arr[i-j+1])

                    if i - j >= 0:
                        dp[i] = max(dp[i], curMax * j + dp[i-j])
                    else:
                        dp[i] = max(dp[i], curMax * j)

        return dp[n-1]
