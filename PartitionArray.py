# TC - O(n * k)
# SC - O(n)
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        if len(arr) == 0:
            return 0
        if len(arr) == 1:
            return arr[0]

        maxSumArr = [0] * len(arr)

        maxSumArr[0] = arr[0]

        for i in range(1, len(arr)):
            maxm = arr[i]
            for j in range(1, k+1):
                if i - j + 1 >= 0:
                    if i - j >= 0:
                
                        maxm = max(
                            maxm, maxSumArr[i-j] + max(arr[i-j+1:i+1])*j)
                        maxSumArr[i] = maxm
                    else:
                        
                        maxm = max(maxm, max(arr[:i+1])*j)
                        maxSumArr[i] = maxm

        return maxSumArr[len(arr) - 1]