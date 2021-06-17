#TC O(nk)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None:
            return None

        dp = [0 for i in range(len(arr))]
        dp[0] = arr[0]
        for i in range(1, len(dp)):
            maxVal = arr[i]
            for j in range(1, k+1):
                if i-j+1>=0 :
                    maxVal = max(maxVal, arr[i-j+1])
                    if i-j>=0:
                        dp[i] = max(dp[i],maxVal*j+dp[i-j])
                    else:
                        dp[i] = max(dp[i],maxVal*j)

        return dp[len(arr)-1]