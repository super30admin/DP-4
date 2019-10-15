//Time COmplexity: O(N)
//SPace COmplexity: O(N)
//Was accepted on leetcode
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) 
    {
        //store the length of the given array
        int N = A.length;
        //initialize a new dp array of the same size as the given array
        int dp[] = new int[N];
        //Iterate over the array
        for(int i=0; i<N; i++)
        {
            //initialise the current max value as 0
            int curMax = 0;
            //start with 'k' from 1 as long as it is smaller than or equal to 'K' and also when i-k+1 > 0 iterate over the subarray
            for(int k=1; k<=K && i-k+1>=0;k++)
            {
                
                int x = 0;
                //update current max value to value at index = i-k+1
                curMax = Math.max(curMax,A[i-k+1]);
                //If k is lesser than or equal to i
                if(i>=k)
                {
                    //x value is dp[i-k]
                     x = dp[i-k];
                }
                else
                //else 0
                     x = 0;
                //update dp[i] to the max between value in dp and curMax*k+x
                dp[i] = Math.max(dp[i],x+(curMax*k));
            }
        }
        //return dp[N-1] as the sum 
        return dp[N-1];
    }
}