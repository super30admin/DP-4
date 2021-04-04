# Created by Aashish Adhikari at 4:50 PM 4/3/2021

'''
Time Complexity:

Each node has k children and there are n total elements in the arr meaning we have the tree height n.  ~ O(k ^ n)
Also, at each node, we are doing max over the elements in the new partition formed. The average value from 1 to k is k/2. Hence. O((k/2) . k^n) ~ O(k . (k^n))

Space Complexity:
Assumining we make k number of variables in each node, O(k .n) ~ O(n) since the height of the tree is n and the space complexity for the recursive stack == the height of the tree.
'''

class Solution(object):

    def helper(self, arr, idx_to_make_partition, curr_sum, k):

        # base case
        if idx_to_make_partition == len(arr):
            pass

        # logic : k cases
        for idx in range(0,k):

            if idx_to_make_partition + 1 + idx <= len(arr):
                next_partition = arr[idx_to_make_partition : idx_to_make_partition + 1 + idx]
                maxx = max(next_partition)
                increment = maxx * len(next_partition)


                summ = curr_sum+increment
                if summ > self.sol:
                    self.sol = summ

                self.helper(arr, idx_to_make_partition + 1 + idx, summ, k)




    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """

        self.sol = 0
        self.helper(arr, 0, 0, k)

        return self.sol
