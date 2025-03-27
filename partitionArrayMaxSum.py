"""
TC - O(n*k)
SC - O(n)
"""


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or len(arr) == 0 or k == 0: return 0

        n = len(arr)
        dp = [0 for i in range(n)]
        # since 0th element's partition cannot be done
        # dp[0] = arr[0]

        # we are starting from 1st element since 0th element is processed in previous line
        for i in range(n):
            # maxVal = dp[i]

            # initialize maxElement to update max(arr[i-j+1 : i]) at each iteration
            maxElement = arr[i]
            # iterate over j and find max sum only if i-j+1 >= 0
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    # find the maxElement
                    maxElement = max(maxElement, arr[i - j + 1])
                    # use dp[i-j] only if i-j >= 0 and otherwise it is 0
                    if i - j >= 0:
                        currSum = (j * maxElement) + dp[i - j]
                    else:
                        currSum = (j * maxElement) + 0

                    # update dp[i]
                    dp[i] = max(dp[i], currSum)

        return dp[n - 1]