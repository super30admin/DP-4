// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Populate the DP array using the maximum value from the previous value in the DP array and the max value in the current partition which will go from 1 to k.

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length == 0) return 0;
        
        int[] dp = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            int max = curr;
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    dp[i] = Math.max(dp[i] , dp[i - j] + max * j);
                    max = Math.max(max, arr[i - j]);
                } else{
                    dp[i] = Math.max(dp[i] , max * j);
                    break;
                }
            }
        }
        
        return dp[arr.length - 1];
    }
}
