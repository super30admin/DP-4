class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n=len(s)
        dp=[False]*(n+1)
        set_=set(wordDict)
        dp[0]=True
        for i in range(n+1):
            for j in range(i):
                if dp[j] and s[j:i] in set_:
                    dp[i]=True
        return dp[n]