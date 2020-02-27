// Time Complexity : O(n*k) where n is the length of array A 
// Space Complexity : O(n) where n is the length of array A 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, couldn't code it myself

// Your code here along with comments explaining your approach

class partitionArrayMaxSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A == null || A.length == 0) return 0;   
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int max = 0; // to find max in each partition
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) { // j is the partition size
                max = Math.max(max, A[i - j + 1]); 
                if (i < j) {
                    dp[i] = Math.max(max * j, dp[i]); // max in partition * size of partition
                } else {
                    dp[i] = Math.max(max * j + dp[i - j], dp[i]);  // max in partition * size of partition + max sum of previous partitions
                }
            }
        }
        return dp[A.length - 1];
    }
}