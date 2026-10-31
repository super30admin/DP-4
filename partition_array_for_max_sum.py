'''
1043 Parition Array for Maximum Sum
https://leetcode.com/problems/partition-array-for-maximum-sum/description/

Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.


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

Constraints:
1 <= arr.length <= 500
0 <= arr[i] <= 109
1 <= k <= arr.length

Solution:
1. Recursion
Recursively try every partition of size up to k starting at index i. For each partition, we find the maximum in that subarray and add its contribution. We return the maximum among all such possible partitioned sums.
Time: O(k^N), Space: O(N) (N = no. of elements in array)
https://youtu.be/C-wjwRek6K0?t=3557

2. DP
Use a bottom-up DP 1d-array to track max sum up to each index.
Let dp[i] = max sum so far up to the ith element

Init dp = [0]*(N+1)
     dp[1] = arr[0]

for i = 2, ... , N
dp[i] = max(dp[i-1] * max(arr[i-1])*1,
            dp[i-2] * max(arr[i-1]), arr[i-2])*2,
            ...,
            dp[i-k] * max(arr[i-1]), arr[i-2], ... arr[i-k])*k )
      =  max_j=1..,k { dp[i-j] + max(arr[i],..arr[i-j])*(i-j) }

Thus, for every index i, we check all partitions of size up to k ending at i (thus start and end index pair of each partition are = <start, end> = <i, i> (len 1), <i-1,i> (len 2), <i-2,i> (len 3), ..., <i- (K-1),i> (len K).
We calculate the contribution of each partition and update dp[i] using the max contribution.

Example:
array =  [1, 15, 7, 9, 2, 5, 10]
Let dp = [0, 1, ?, ?, ?, ?, ?, ?] (1 more than size of array)

i=2
dp[2] = max(dp[1] + max(15)*1, dp[0] + max(1,15)*2) = 30
dp = [0, 1, 30, ?, ?, ?, ?, ?]

i=3
dp[3] = max(dp[2] + max(7)*1, dp[1] + max(15,7)*2, dp[0] + max(1,15,7)*3) =
      = max(30+7, 1+30, 0+45) = 45
dp = [0, 1, 30, 45, ?, ?, ?, ?]

dp[4] = max(dp[3] + max(9)*1, dp[2] + max(7,9)*2, dp[1] + max(15,7,9)*3) =
      = max(45+9, 30+18, 1+45) = max(54,48,46) = 54

Time: O(Nk), Space: O(N) (N = no. of elements in array)
Time is Nk because to compute dp[i], we go back k steps to compute the contribution of each of the k partitions towards dp[i].
https://youtu.be/C-wjwRek6K0?t=3892
'''

# works
# def maxSumAfterPartitioning_Recursion(arr, k):
#     def recurse(arr, index, tot):
#         nonlocal max_tot
#         if index == N:
#             max_tot = max(max_tot, tot)
#             return

#         for j in range(index, index+k):
#             if j < N:
#                 l = j+1-index # len of subarray <= k
#                 this = max(arr[index:j+1])*l
#                 recurse(arr, j+1, tot+this)

#     if not arr:
#         return 0
#     N = len(arr)
#     max_tot = 0
#     recurse(arr, 0, 0)
#     return max_tot

def maxSumAfterPartitioning_Recursion(arr, k):
    def recurse(pivot, path):
        nonlocal max_tot, result
        # base
        if pivot == N:
            # flatten the path
            flatten = [item for sublist in path for item in sublist]
            if sum(flatten) > max_tot:
                max_tot = sum(flatten)
                result = flatten.copy()
            return

        # logic
        for j in range(pivot, pivot+k):
            if j < N:
                numel = j - pivot + 1
                path.append([max(arr[pivot:j+1])]*numel)
                recurse(j+1, path)
                path.pop()

    if not arr:
        return 0
    N = len(arr)
    path = []
    result = []
    max_tot = 0
    recurse(0, path)
    return max_tot, result

def maxSumAfterPartitioning_DP_1(arr, k):
    if not arr:
        return 0
    N = len(arr)
    dp = [0]*N
    dp[0] = arr[0]
    for j in range(1, N):
        max_val = 0
        for le in range(1, k+1):
            i = j-le # dp index
            if i >= 0: # dp index is valid?
                this = dp[i] + max(arr[i+1:j+1])*le
            elif i+1 >= 0: # array index is valid?
                this = max(arr[i+1:j+1])*le
            else:
                this = 0
            max_val = max(max_val, this)
        dp[j] = max_val
    return dp[N-1]

def maxSumAfterPartitioning_DP_2(arr, k):
    ''' DP logic is identical to that of maxSumAfterPartitioning_DP_1() but this one is easier to follow due to fewer state variables '''
    if not arr:
        return 0
    N = len(arr)
    dp = [0]*(N+1)

    dp[1] = arr[0]
    mx = arr[0]

    # Compute dp for: dp[2],..dp[N]
    for i in range(2,N+1):
        ln = 0
        curr_dp = 0
        mx = arr[i-1]
        for j in range(1, k+1):
            if i - j >= 0:
                mx = max(mx, arr[i-j])
                ln += 1
                curr_dp = max(curr_dp, dp[i-j] + mx*ln)
        dp[i] = curr_dp
        #print(f" index = {i}, dp = {dp}")
    return dp[N]

def run_tests():
    tests = [([1,15,7,9,2,5,10],3,84),
             ([1,4,1,5,7,3,6,1,9,9,3],4,83),
    ]
    for test in tests:
        arr, k, ans = test[0], test[1], test[2]
        print(f"\nArray = {arr}")
        print(f"k = {k}")
        for method in ['recur', 'dp1', 'dp2']:
            if method == 'recur':
                max_sum, ptn = maxSumAfterPartitioning_Recursion(arr, k)
                print(f"Method {method}: {max_sum}, partition = {ptn}")
            elif method == 'dp1':
                max_sum = maxSumAfterPartitioning_DP_1(arr, k)
                print(f"Method {method}: {max_sum}")
            elif method == 'dp2':
                max_sum = maxSumAfterPartitioning_DP_2(arr, k)
                print(f"Method {method}: {max_sum}")
            passed = (ans == max_sum)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()
