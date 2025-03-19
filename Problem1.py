#time complexity o(n^2)
#space complexity o(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        myset = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in myset:
                    dp[i] = True
                    break

        return dp[n]
