# As taught in class, using dynamic programming to comapre the incomming element and current max and adding them to append into DP array 
#Time Complexity (k^n)
#Space Complexity O(n)
arr = [1,15,7,9,2,5,10]
k = 3
def kpart(arr,k):
    if arr is None or len(arr)==0:
        return 0
    n = len(arr)
    maxi = 0
    dp = [0 for i in range(n)] 
    for i in range(n):
        for j in range(1,k):
            if i-j+1 >0:
                maxi = max(maxi,arr[-j+1])
                dp[i] = max(dp[i],dp[i-j]+maxi*j)
            else:
                dp[i] = max(dp[i],maxi*j)
    return dp[n-1]
s = kpart(arr,k)
print(s)
