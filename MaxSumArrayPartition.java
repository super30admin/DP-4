class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int maxCurPath = arr[i];
            // make all possible partitions till i
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {

                maxCurPath = Math.max(arr[i - j + 1], maxCurPath);

                int currSum = (maxCurPath*j) ;
                if(i-j >=0){
                    currSum = currSum + dp[i-j];
                }
                dp[i] = Math.max(dp[i], currSum);
            }
            
        }

        return dp[n-1];
    }
}