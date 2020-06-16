// Time Complexity : O(nk) where n is the number of elements in the matrix and k is the number of partitions
// Space Complexity : O(n) where we are storing the previous best case found in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficult to come up with this approach
/* Your code here along with comments explaining your approach: We have K partitions, so we will start the partitions with 1 and end up having k
partitions. We will take the max at each case when K =1,2,.....K. At each partition we will take the maximum elment, and sum the max element in the
subarray for each of the partitions , at the end we keep the maximum sum from all the partitions we have. The max sum is the best case for us and is
stored in the ith index for the ith element. For the next element, we repeat the process with the difference is that for calculation and optimisation
we use the previous result by using our pattern as mentioned in the code (as per observation) and return the result as the last element of our dp array.
*/
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0){return 0;}
        int[] dp = new int[A.length];                                                                   // DP array to use previous results
        int max = 0;
        for(int i =0 ; i < dp.length; i++){
            int j = 1;
            max  = 0;                                                           // Reset your max
            while(i-j+1 >= 0 && j <= K){                                        // While partition j < = k partitions, j will start from 1
            max = Math.max(A[i-j+1], max);                                  // Keep the max element in the subarray
            if(i >= j){
                dp[i] = Math.max(dp[i], dp[i-j]+max*j);                                             // DP Patter, use the (i-j)th result + the maximum till now * j partition number
            } else {
                dp[i] = Math.max(dp[i], max * j);                               // Initial cases when i < j
            }
            j++;
        }
        }
        return dp[dp.length-1];                                                 // Return the last element as the result
    }
}