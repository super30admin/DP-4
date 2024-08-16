def maxSumAfterPartitioning(arr, k):
    n = len(arr)
    dp = [0] * (n + 1)
    
    for i in range(1, n + 1):
        current_max = 0
        for j in range(1, min(k, i) + 1):
            current_max = max(current_max, arr[i - j])
            dp[i] = max(dp[i], dp[i - j] + current_max * j)
        print(dp)
    
    return dp[n]

arr = [1, 15, 7, 9, 2, 5, 10]
k = 3
result = maxSumAfterPartitioning(arr, k)
print("The maximum sum after partitioning is:", result)

#time = O(n x k)
#space = O(n)
