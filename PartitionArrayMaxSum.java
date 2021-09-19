//https://leetcode.com/problems/partition-array-for-maximum-sum/
/*
Time: O(NK) where N = A.size()
Space: O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class PartitionArrayMaxSum {
    public int maxSumAfterPartitioning(int[] A, int K) {

        int[] dp = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            /**
             * We want to partition the array in such a way that we expand the current
             * window to size K backwards and use the dp value at i - K if it exists in our
             * solution
             * 
             **/

            int windowMax = 0;

            // k is my window size
            // k can be almost of size K - max window size available
            // current position - window size should be greater than equal to 0
            // we don't want the window to skid through the first position

            for (int k = 1; k <= K && (i - (k - 1) >= 0); k++) {

                windowMax = Math.max(windowMax, A[i - (k - 1)]);

                dp[i] = Math.max(dp[i], (i - k >= 0 ? dp[i - k] : 0) + (windowMax * k));

            }

        }

        return dp[A.length - 1];
    }

}
