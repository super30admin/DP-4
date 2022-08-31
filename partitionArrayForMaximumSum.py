
#Time Complexity: O(N*k)
#Space Complexity: O(N)
def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
    if not arr:
        return 0

    dp = [0] * len(arr)
    dp[0] = arr[0]
    for i in range(1, len(arr)):
        nMax = arr[i]
        for j in range(1, k + 1):
            # currSum = sum of curr partition + repeated sub problem
            # check inbounds
            if (i - j + 1) < 0:
                break
            # doing this to make sure we are using the max element in the subset
            nMax = max(nMax, arr[i - j + 1])
            if (i - j) >= 0:
                curr = j * nMax + dp[i - j]
            else:
                curr = j * nMax
            dp[i] = max(dp[i], curr)
    return dp[-1]