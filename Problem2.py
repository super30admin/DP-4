# Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)
# Time Complexity: O(n * k),We loop through every index i from 1 to n-1, that is n indices. For each index i, we loop through chunk sizes j from 1 to k. 
# Space Complexity: O(n),The only extra memory we use is the dp array, which has n slots.
# Approach:
# dp[i] means the best possible sum using only elements from index 0 to index i.
# To build dp[i], we look at the last chunk ending at index i.
# That chunk can have length 1, 2, 3, up to k, so we try every length.
# For a chunk of length j ending at i, the chunk starts at index i - j + 1.
# We track current_sum as the max value inside that chunk as we grow it one element at a time.
# The chunk's contribution to the sum is current_sum * j, since every value in the chunk becomes the max.
# If there is anything before the chunk (index i - j is 0 or more), we add dp[i - j], the best sum for everything before the chunk.
# If the chunk goes all the way back to the start, there is nothing before it, so we just use the chunk's contribution alone.
# We keep the biggest total across all chunk lengths in dp[i].
# The final answer is dp[n - 1], since that covers the whole array.

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n         # dp[i] will hold the best sum using arr[0..i]
        dp[0] = arr[0]      # base case, with only one element the best sum is just that element

        for i in range(1, n):   # build dp for every index from 1 to n-1
            current_sum = 0     # will track the max value inside the chunk we are currently testing

            for j in range(1, k + 1):    # j is the length of the last chunk ending at index i
                if i - j + 1 < 0:
                    break       # chunk of this length does not fit inside the array, stop trying longer lengths

                current_sum = max(current_sum, arr[i - j + 1])      # grow the chunk by one element to the left, update its max

                if i - j >= 0:
                    # there is a part of the array before this chunk, add its best sum
                    dp[i] = max(dp[i], current_sum * j + dp[i - j])
                else:
                    # chunk covers everything from the start, nothing to add before it
                    dp[i] = max(dp[i], current_sum * j)

        return dp[n - 1]  # best sum using the entire array