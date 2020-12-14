class Solution:
    def maxSumAfterPartitioning(self, arr, k: int) -> int:
        self.maxval=0
        @lru_cache(maxsize=None)
        def maxp(lower):
            if lower==len(arr):
                return 0
            maxval=maxele=0
            for i in range(lower,min(len(arr),lower+k)):
                maxele=max(maxele,arr[i])
                maxval=maxele*(i-lower+1)+maxp(i+1)
                self.maxval=max(self.maxval,maxval)
            return maxval
        maxp(0)
        return self.maxval