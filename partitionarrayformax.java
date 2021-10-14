
time complexity: O(n*k)
space complexity: O(n)

//using dynamic programming, we can traverse on the array, make partitions and then calculate sum

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int [] dp = new int[len];
        for(int i = 0; i<len; i++){
            dp[i] = Integer.MIN_VALUE;
            int curMax = arr[i];

            for(int l = 1; l<=k & i-l+1>=0; l++){
                curMax = Math.max(curMax, arr[i-l+1]);
                dp[i] = Math.max(dp[i], (i-l<0 ? 0 : dp[i-l]) + curMax*l);
            }
        }

        return dp[len-1];
    }
}
