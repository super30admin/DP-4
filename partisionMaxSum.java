/*
TC --> O(n*k)
SC --> O(n)
 */
class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        System.out.println(dp[0]);
        int l;
        int max_val;
        int sum_val;
        int max_sum;
        for (int i = 1; i < n; i++) {
            l = 1;
            max_val = 0;
            max_sum = 0;
            for (int j = i; j > i - k && j >= 0; j--) {
                max_val = Math.max(max_val, arr[j]);
                sum_val = max_val * l;
                if (j - 1 >= 0) {
                    sum_val += dp[j - 1];
                }
                l++;
                max_sum = Math.max(sum_val, max_sum);
            }//for

            dp[i] = max_sum;
            //System.out.println(dp[i]);

        }//for

        return dp[n - 1];
    }//method
}//class
