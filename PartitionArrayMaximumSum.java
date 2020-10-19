/* 1043. Partition Array for Maximum Sum - MEDIUM
https://leetcode.com/problems/partition-array-for-maximum-sum/

Approach: Brute force - get all partitions with length upto k, and get the max sum
This problem has smaller overlapping problems - max sum at position i is the max sum if cut is made at j;
(where j can take values between 1 and k) plus the max value in the remaining array.
*/

public class PartitionArrayMaximumSum {
    // Recursive with memoization solution //
    // Recursion without memoization - TLE in Leetcode
    /* TC: O(nk) - not sure about this
       SC: O(n) - the maximum number of calls in the stack at any point will be maximum n
    */

    int[] dp;
    public int maxSumAfterPartitioningRec(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // Initialize dp array
        dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        
        return maxSum(arr, k, arr.length - 1);
    }
    
    private int maxSum(int[] arr, int k, int n) {
        if (n < 0) {
            return 0;
        }        
        if (dp[n] != -1) {
            return dp[n];
        }

        int globalMax = Integer.MIN_VALUE;
        
        int maxValue = arr[n];
        for (int i = 1; i <= k && (n-i+1) >= 0; i++) {
            maxValue = Math.max(maxValue, arr[n-i+1]);
            globalMax = Math.max(globalMax, maxSum(arr, k, n - i) + maxValue * i);
        }
        
        dp[n] = globalMax;
        return globalMax;
    }

    //////////////////////////////////////////////////////
    // Bottom up solution
    /* TC: O(n * k)
       SC: O(n)
    */
    public int maxSumAfterPartitioningItr(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int[] dp = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            
            for (int j = 1; j <= k && (i - j + 1) >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        
        return dp[arr.length - 1];
    }
}
