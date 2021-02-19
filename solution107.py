#Time Complexity:O(nk)
#Space Complexity:O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if len(arr)==0:
            return
        dp=[0]*len(arr)                                         #craete a dp array of size n
        for i in range(len(dp)):
            mx=dp[i]                                            # every position at dp hold the max value possible at the point after exploring various partitions
            for j in range(1,k+1):                              #for partitions of range 1 to k
                if i-j+1>=0:                                    #while the partition is within the dp array
                    mx=max([mx,arr[i-j+1]])                     #update the max value
                    if i-j>=0:                                  
                        dp[i]=max([dp[i],(mx*j)+dp[i-j]])       #the current position will hold the max value between current value and max*size of partition plus the value before current partition limit
                    else:
                        dp[i]=max([dp[i],(mx*j)])               
        return dp[-1]