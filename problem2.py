#time complexity: O(n*k)
#space complexity: O(n)
#ran on leetcode: Yes
#For each element, loop for size 1 to K with variable k, for each subarray calcuate the best value
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0]*len(arr)
        #print(dp)
        for i in range(len(arr)):
            K=0
            best=-1
            while(K!=k):
                if(i-K>=0):
                    best=max(best,arr[i-K])
                    res=0
                    if(i-K-1>=0):
                        res=dp[i-K-1]
                    dp[i]=max(dp[i], (best*(K+1)) +res)
                K+=1
        return dp[-1]

