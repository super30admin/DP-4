#  https://leetcode.com/problems/word-break/

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.wdset = set(wordDict)
        self.memoSet = set() # this remembers already checked strings
        n = len(s)
        return self.helper(s,self.wdset,self.memoSet)
    
    def helper(self,s,wdset,memoSet):
        if len(s) == 0:
            return True
        if s in memoSet:
            return False
        
        for i in range(len(s)): #O(n)
            ss = s[0:i+1]
            if ss in self.wdset:
                rest = s[i+1:] # checks for rest of the string but remembers so NO Recalculation
                interresult = self.helper(rest,wdset,memoSet)
                if interresult:
                    return True
                else:
                    self.memoSet.add(rest)
        
        return False

# TC: O(n^2)
# SC: O(n) for memoSet