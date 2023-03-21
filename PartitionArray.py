"""
Rasika Sasturkar
Time complexity: O(n*k), for every element creating k partitions
Space complexity: O(n)
"""


def maxSumAfterPartitioning(arr, k: int) -> int:
    if arr is None:
        return 0

    n = len(arr)
    dp = [0 for _ in range(n)]
    dp[0] = arr[0]

    for i in range(1, n):
        max_sum = arr[i]
        for j in range(1, k + 1):
            if i - j + 1 >= 0:
                max_sum = max(max_sum, arr[i - j + 1])
                curr_partition = max_sum * j
                if i - j >= 0:
                    curr_partition = max_sum * j + dp[i - j]
                dp[i] = max(dp[i], curr_partition)
    return dp[n - 1]


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(maxSumAfterPartitioning(arr=[1, 15, 7, 9, 2, 5, 10], k=3))  # returns 84
    print(maxSumAfterPartitioning(arr=[1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3], k=4))  # returns 83
    print(maxSumAfterPartitioning(arr=[1], k=1))  # returns 1


if __name__ == "__main__":
    main()
