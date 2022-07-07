//time complexity : O(n*k) n is length of input string
//space complexity : O(n) n is length of dict

class Solution {

    //code 1

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];

        dp[0] = arr[0];

        for(int i=0; i<dp.length; i++) {

            int max = arr[i];

            for(int j=1; j<=k && i-j+1>=0; j++) {
                max = Math.max(max, arr[i-j+1]);
                if(i-j >= 0) {
                    dp[i] = Math.max(dp[i], max*j + dp[i-j]);
                } else {
                    dp[i] = Math.max(dp[i], max*j);
                }
            }

        }

        return dp[dp.length - 1];

    }
}
