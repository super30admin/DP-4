'''
TC: O(n)
SC: O(n)

Intuition:

- At any point of time, consider element at that point and slowly increase the window backwards by 1 and partition it
- Ex. - [1, 15, 7, 9]
- [1]
- [1, 15] -- first itr 15 + 1, second itr - max(15, 1) * 2 = 30
- [1, 15, 7] -- first itr 7 + dp[1--15] = 37, second itr = max(15, 7) * 2 + [1] = 31, third itr = max(1, 15, 7) * 3 = 45
- and so on


'''

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr or not k:
            return 0
        
        alen = len(arr)
        dp = [0 for i in arr]
        dp[0] = arr[0]
        
        for i in range(1, alen):
            maxm = arr[i]
            for j in range(min(k, i+1)):
                maxm = max(maxm, arr[i - j])
                dp[i] = max( dp[i], maxm * (j+1) + (dp[i - j - 1] if (i - j - 1) >= 0 else 0) )
        
        return dp[-1]
        