#Space Complexity = O(1)
#Time Complexity = O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if(arr== None or len(arr)==0):
            return 0
        dp = [0 for _ in range(len(arr))]
        dp[0] = arr[0]
        for i in range(1,len(dp)):
            max_val = arr[i]
            for j in range(1,k+1):
                if (i-j+1>=0):
                    max_val = max(max_val,arr[i-j+1])
                    if(i-j>=0):
                        dp[i] = max(dp[i],max_val*j+dp[i-j])
                    else:
                        dp[i] = max(dp[i],max_val*j)
        print(dp)
        return dp[-1]
            