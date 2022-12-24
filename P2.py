# TC : O(len(arr) * k)
# SC : O(len(arr))
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0]*n
        for i in range(k):
            dp[i] = max(arr[:i+1]) * (i+1)
        # print(dp)
        for j in range(k, n):
            curr = []
            for i in range(k):
                res = dp[j - i - 1] + max(arr[(j-i):(j+1)]) * (i + 1)
                # print("j:", j, "i:",i,"res->",res)
                curr.append(res)
            dp[j] = max(curr)
            # print(curr)
        return dp[-1]
        