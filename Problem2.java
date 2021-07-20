
// Time - O(K * N)

// Space - O(N)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        if(arr == null || arr.length == 0) return 0;
        int [] dp = new int[arr.length];
        dp[0] = arr[0];   // put the first element of arr in the dp array

        for(int i = 1; i < dp.length; i++) {
            int max = arr[i];      // max will be element of index i

            for(int j = 1; j<=k && i - j + 1 >= 0; j++) {

                max = Math.max(max, arr[i - j + 1]); // i - j + 1 is the incoming paritition value when we run k paritition & compare it with the elements of original array

                if(i - j >= 0) {  // edge case if it goes out of bound

                    dp[i] = Math.max(dp[i], dp[i - j] + max*j); // dp[i] is the previous total of paritition compared with incremental paritition


                }
                else {

                    dp[i] = Math.max(dp[i], max*j); // if it goes out of bound only add max*j value

                }

            }

        }

        return dp[arr.length - 1];

    }
}