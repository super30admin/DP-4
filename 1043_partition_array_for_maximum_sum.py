"""

## Problem 1043: Partition array for maximum sum

## Author: Neha Doiphode
## Date:   10-04-2022

## Description:
    Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
    After partitioning, each subarray has their values changed to become the maximum value of that subarray.

    Return the largest sum of the given array after partitioning.
    Test cases are generated so that the answer fits in a 32-bit integer.

## Examples:
    Example 1:
        Input: arr = [1,15,7,9,2,5,10], k = 3
        Output: 84
        Explanation: arr becomes [15,15,15,9,10,10,10]

    Example 2:
        Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
        Output: 83

    Example 3:
        Input: arr = [1], k = 1
        Output: 1

## Constraints:
    1 <= arr.length <= 500
    0 <= arr[i] <= 109
    1 <= k <= arr.length

## Time complexity: O(n k), where n is the length of the array, k is the size of max allowed partition.
                    We loop over the array and at every element we try to make paritions of size k, k - 1, ...1.
                    Which means per element the inner loop runs k times.

## Space complexity: O(n), where n is the length of the array. Auxiliary DP array with size n is used in the solution.
"""

from typing import List, Optional

def get_input():
    print("Enter the array of integers(with spaces): ", end = "")
    arr = input()
    arr = [int(element) for element in arr.split()]
    print("Enter max allowed partition size(integer): ", end = "")
    k = int(input())
    return arr, k

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        """
        1,15, 7, 9, 2, 5, 10

        1 30 45 54 63 72

        1 ============================================> 1
        15,       15 + 15 =================================> 30
        7 + 30,   15 + 15,       15 + 15 + 15      ===> 45
        9 + 45,   9 + 9 + 30 ,   15 + 15 + 15      ===> 54
        2 + 54,   9 + 9 + 45,    9 + 9 + 9 + 30    ===> 63
        5 + 63,   5 + 5 + 54,    9 + 9 + 9 + 45    ===> 72
        10 + 72,  10 + 10 + 63,  10 + 10 + 10 + 54 ===> 84
        """

        if len(arr) == 0:
            return 0

        # initialize dp array
        n  = len(arr)
        dp = [0] * n

        # Declare max_sum
        max_element = 0

        # First dp element is same as first array element.
        dp[0] = arr[0]

        # Since we already assigned first element, start with second element of the array.
        for index in range(1, n):
            # Max sum at index i
            max_element = arr[index]
            """
            We can make parition of at the max size k.
            So,
            1, 15, 7 ==> Can be considered as parition of size 3
            1, 15    ==> Can be considered as partition of size 2
            1        ==> Can be considered as partition of size 1

            0       1       2       3
            1       15      7       9

            At index 2, we want the inner loop to run k times.
            For index = 3, k = 3, j = 1 ====> arr[3]
                index = 3, k = 3, j = 2 ====> arr[2]
                index = 3, k = 3, j = 3 ====> arr[1]
            """
            for j in range(1, k + 1):
                # First decide out of 7, 7 & 15, 7 & 15 & 1 combinations which is the max element
                if index - j + 1 >= 0:
                    max_element = max(max_element, arr[index - j + 1])
                    # In case of indices 0 and 1 we can not make partition of size 3
                    if index - j >= 0:
                        dp[index]   = max(dp[index], max_element * j + dp[index - j])
                    else:
                        dp[index]   = max(dp[index], max_element * j)
        return dp[-1]


# Driver code
solution = Solution()
arr, k = get_input()
print(f"Input: Array: {arr}")
print(f"Input: Max allowed parition size: {k}")
print(f"Output: Dyanamic programming: Maximum sum after partitioning: {solution.maxSumAfterPartitioning(arr, k)}")
