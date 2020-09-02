// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach 1: DP
// Time Complexity : O(n*K)
//      n: number of elements in matrix
//      K: number of partitions
// Space Complexity : O(n)
//      dp matrix size
class Problem2S1 {

    /** find max sum after partitionng */
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        // edge case
        if(A == null || A.length == 0 || K == 0)
            return 0;
        // initialize
        int n = A.length;
        int[] dp = new int[n];
        int max = 0;

        // iterate
        for(int i=0; i<n;i++){
            // max value
            max = A[i];

            // iterate paritions
            for(int j =1; j<= K && i-j+1 >= 0; j++){   
                // take max from previous values
                max = Math.max(max, A[i-j+1]);
                // Previous calculate values present
                if(i-j >= 0)
                    dp[i] = Math.max(dp[i], max*j +dp[i-j]);
                // not present
                else
                    dp[i] = Math.max(dp[i], max*j);
            }
          
        }
        //final calculated sum
        return dp[n-1];
    }
}
// Your code here along with comments explaining your approach
// Approach 2: DP with different size of dp matrix
// Time Complexity : O(n*K)
//      n: number of elements in matrix
//      K: number of partitions
// Space Complexity : O(n+K)
//      dp matrix size
class Problem2S2 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        if(A == null || A.length == 0 || K == 0)
            return 0;
        // initializing and adding K as well for dp
        int n = A.length+K;
        int[] dp = new int[n];
        int max = 0;

        // iterate elements for dp starting from K
        for(int i=K; i<n;i++){
            max = A[i-K]; // to get actually index of A

            // iterate for K partitions (Take K partitions)
            for(int j =1; j<= K && i-K-j+1 >= 0; j++){   //here i-K-j+1 can become negative

                // take max value of current partition
                max = Math.max(max, A[i-K-j+1]); 
                // multiply j to max and add previous calculated dp
                dp[i] = Math.max(dp[i], max*j +dp[i-j]); 
            }
          
        }
        //final calculated sum
        return dp[n+K-1];
    }
}