// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem we maintain an array to store the maximum sum of all the partitions whose length is less than or equal to k at the given position.we start this problem with recursion with the following logic:

consider an array is_valid which stores the max value at a particular position.so,

is_valid[i]=MAX(is_valid[i],(j*max(maxi,A[i-j+1]))+is_valid[i-j]) where 1<=j<=k which means taking the max value at i-j location and number of elements multiplied with the maximum element in the array.for every iteration till k iterations we see at which iteration it has the maximum value.


# Time complexity --> o(n*k)
# space complexity --> o(n)
class Solution(object):
    def maxSumAfterPartitioning(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        if A==None or len(A)==0:
            return 0
        is_valid = [0 for i in range(len(A))]
        is_valid[0] = A[0]
        for i in range(len(A)):
            maxi=A[i]
            for j in range(1,K+1):
                if i-j+1>=0:
                #taking the maximum element in A[i-j+1:i] array
                    maxi=max(maxi,A[i-j+1])
                    if i-j<0:
                        x=0
                    else:
                        x=is_valid[i-j]
                #multiplying the length of the array with the maximum element in the array and also considering the max value at i-j location.
                    val=(j*maxi)+x
                    is_valid[i]=max(is_valid[i],val)
        return is_valid[len(A)-1]