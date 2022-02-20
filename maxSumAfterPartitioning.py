class Solution:
    '''
    Greedy - take the max element, 
    partition into K sub arrays
    then convert it and add 

    1 , 15, 10, 1, 1, 2
    if we take k = 3 
    15*3 + 2*3 

    if we take k = 2 
    15*2 + 10*2 + 2*2 
    '''
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        dp= [0]*len(arr)
        dp[0]=arr[0]
        for i in range(1,len(dp)):
            # print(i)
            m=dp[i]
            j=1
            while(j<=k and i-j+1>=0):
                m = max(m,arr[i-j+1])
                if(i-j)>=0:
                    dp[i]=max(dp[i],dp[i-j]+m*j)
                else:
                    dp[i]=max(dp[i],m*j)  #edge condition for first trio
                j+=1
        return dp[len(dp)-1]
