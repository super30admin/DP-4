/* Given an integer array arr, you should partition the array into (contiguous) subarrays of length at most k
* TC O(N*K) SC O(N)
*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int [] dp = new int [arr.length];
        for (int i = 0; i< arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= k && (i - j + 1) >=0 ; j++) {
                max = Math.max(max, arr[i-j+1]);
                if (i >= j) {
                    dp[i] = Math.max(dp[i], dp[i-j] + max*j);
                }
                else {
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[arr.length -1];
    }
}
