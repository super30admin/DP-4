class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        maxsum = [0] * len(arr)
        for i in range(len(arr)):
            maxx = arr[i]
            j = 1
            while i - j + 1 >= 0 and j <= k:
                maxx = max(maxx, arr[i - j + 1])
                if i - j >= 0:
                    maxsum[i] = max(maxsum[i], maxsum[i - j] + maxx * j)
                else:
                    maxsum[i] = max(maxsum[i], maxx * j)
                j += 1
        return maxsum[-1]

    # time-O(nk) space-o(1)