#Approach : DP - Bottom up
"""
1) Start with DP array, for every incoming element, generate k candidates. Basically, generate all possible partitions:
    Example: if 9 is the incoming element: candidates are:
        arr   1  15  7   9   2  5  10
        DP 0  1  30  45  ?
        a) 45 + 9 = 54
        b) 30 + 9*2 = 48
        c) 1  + 15*3 = 45
2) Pick the max candidate for your dp array. The last element would give the final result

TC: O(n*k)
SC: O(n)
"""
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0]*(n+1) # since starting the DP array with zero
        for i in range(1,n+1):
            max_item = dp[i]
            end = i
            start = max(1, i-k+1) # if you go k steps back to generate all possible cadidates, you'd go till the start pointer i.e i-k+1th index.
            #Also, if i = 2 and k = 5, you'd want to keep the j pointer in bounds. Taking max(1) instead of max(0) beacuse our dp array has an extra element at index 0.
            for j in range(end, start-1, -1):
                max_item = max(max_item, arr[j-1]) # get max of k elements, one at a time
                dp[i] = max(dp[i], dp[j-1]+(max_item*(i-j+1)))
        return dp[-1]
                