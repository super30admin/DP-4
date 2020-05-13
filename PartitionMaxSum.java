// 1043.
// time - O(nK)
// space - O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        //edge
        if(A == null || A.length == 0)
        {
            return 0;
        }
        int[] maxSum = new int[A.length]; //dp array
        for(int i = 0; i < A.length; i++)
        {
            //for k = 3, ith element can go as a single partition - in this case dp[i] = A[i] + dp[i - 1]
            //ith element can be combined with i-1st element - dp[i] = 2*max(A[i], A[i - 1]) + dp[i - 2]
            //ith element can be combined with i-1st element and i-2nd element - dp[i] = 3*max(A[i], A[i - 1], A[i - 2]) + dp[i - 3]
            int maximum = 0;  //to track max as k grows from 1 to k
            for(int j = 1; j <= K; j++)
            {
                if(i - j + 1 >= 0) //i-j+1st index in A gets the newly added element as k grows
                {
                    maximum = Math.max(maximum, A[i - j + 1]); //updating max
                    if(i - j >= 0)
                    {
                        maxSum[i] = Math.max(maxSum[i], j * maximum + maxSum[i - j]);
                    }
                    else
                    {
                        maxSum[i] = Math.max(maxSum[i], j * maximum); //i-j is out of bounds
                    }
                }
            }
        }
        return maxSum[A.length - 1];
    }
}
