//Time complexity: O(n*k)
//Space Complexity: O(n)
//Did the code run successfully in LeetCode = yes


package com.madhurima;

public class PartitionArrayForMaximumSum {
}

class PartitionArrayForMaximumSum1 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0){
            return 0;
        }

        int max = 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            max = arr[i];
            for(int j = 1; j <= k && i - j + 1 >= 0; j++){ //window size
                max = Math.max(max, arr[i-j+1]);
                if(i-j >= 0){
                    dp[i] = Math.max(dp[i], max*j + dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i], max*j);
                }

            }
        }

        return dp[n-1];
    }
}
