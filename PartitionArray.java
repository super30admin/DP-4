// sc- o(n) tc o(kn)


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length; i++){
            max = arr[i];
            for (int j = 1; j <= k && i-j+1 >= 0 ; j++){ // check if in bounds
                 // find max element between incoming and curr element
                max= Math.max(max,arr[i-j+1] );
                if (i-j >= 0){
                     dp[i] = Math.max(dp[i], dp[i-j]  + max*j); // considers all the k paritions
                } else {
                    dp[i] = Math.max(dp[i], max*j);
                }

            }

        }
        return dp[arr.length-1];
    }
}
