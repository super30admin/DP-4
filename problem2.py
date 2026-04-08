# problem 2

# https://leetcode.com/problems/partition-array-for-maximum-sum/description/

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp_arr = [0]*n
        dp_arr[0] = arr[0]
        for i in range(1,n):
            curr_max = 0
            for j in range(1,k+1):
                if i - j + 1 < 0:
                    break
                curr_max = max(curr_max,arr[i-j+1])
                print(curr_max)
                if i - j >= 0:
                    dp_arr[i] = max(dp_arr[i],curr_max*j+dp_arr[i-j])
                else:
                    dp_arr[i] = max(dp_arr[i],curr_max*j)
        return dp_arr[-1]