# Created by Aashish Adhikari at 5:39 PM 4/3/2021

'''
Time Complexity:
O(n.k) where n is the lenght of the array

Space Complexity:
O(n)
'''

class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """

        dp = [0 for idx in range(0, len(arr))]

        # for each position
        for i in range(0, len(arr)):

            maxx = 0
            # for each possible parition that starts at j and ends at i
            for j in range(i-k+1, i+1,+1):

                if j >= 0:

                    partition  = arr[j:i+1]

                    local_max = max(partition)

                    if j-1 >= 0:

                        new_max_possible = dp[j-1] + (local_max * len(partition))

                    else:
                        new_max_possible = local_max * len(partition)

                    if new_max_possible > maxx:

                        maxx = new_max_possible



            # required for the first element, else becomes 0.
            dp[i] = max(arr[i],maxx)
            maxx = 0

        return dp[-1]








