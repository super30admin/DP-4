# time complexity is o(nk), where n is the size of the input array and k is size of partition
# space complexity is o(n), where n is the size of the input array
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0 for i in range(n+1)]
        dp[0] = arr[0]
        for i in range(1, n):
            maxi = arr[i]
            for j in range(1, k+1):
                if(i - j + 1 >= 0):
                    maxi = max(maxi, arr[i - j + 1])
                    curr = 0
                    if(i - j >= 0):
                        curr = j*maxi + dp[i - j]
                    else:
                        curr = j*maxi
                    dp[i] = max(dp[i], curr)
        return dp[n-1]

            
        
        
        
        
#         n = len(arr)
#         dp = [0 for i in range(n)]
#         dp[0] = arr[0]
#         for i in range(1, n):
#             maxi = arr[i]
#             for j in range(1, k+1):
#                 if(i - j + 1 >= 0):
#                     maxi = max(maxi, arr[i - j + 1])
#                     curr = 0
#                     if(i - j >= 0):
#                         curr = j*maxi + dp[i - j]
#                     else:
#                         curr = j*maxi
#                     dp[i] = max(dp[i], curr)
#         return dp[n-1]

            
        