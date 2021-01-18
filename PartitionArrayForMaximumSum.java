/** 
 * TC: O(n * k)
 * SC: O(n)
 * LeetCode: Y(https://leetcode.com/problems/partition-array-for-maximum-sum/)
 * Approach: 
    Brute force: Generate all partitions, replace each element in the partiton with max, and calculate sum
    DP Approach: Remember the max sum for each partition seen
 */

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // check edge case
        if(arr == null || arr.length == 0) {
            return 0;
        }
        
        // create dp matrix - stores the max sum for respective indices
        int[] dp = new int[arr.length];
        
        // iterate through the input array
        for(int i = 0 ; i < arr.length ; i++) {
            // re-initialize currentMax
            int currentMax = Integer.MIN_VALUE;
            
            // See each partition from length to 1 to length k from arr[i]
            for(int j = 1 ; (j <= k) && (i - j + 1 >= 0); j++ ) {
                // get current max
                currentMax = Math.max(currentMax, arr[i - j + 1]);
                
                // if a valid partition before current element exists
                if(i >= j) {
                    dp[i] = Math.max(dp[i], dp[i - j] + currentMax * j);
                }
                // when the current index is less than k
                else {
                    dp[i] = j * currentMax;
                }
                
            }
        }
        // return the sum at the end of the array
        return dp[dp.length - 1];
    }
}
