// Time Complexity :  O(Nk) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution{
public int maxSumAfterPartitioning(int[] arr, int k) {
    if(arr == null || arr.length == 0) return 0;
    int[] dp = new int[arr.length + 1];
    for(int i = 0; i < arr.length ; i++){
        int max = arr[i];
        for(int j = 1; i - j + 1 >= 0 && j <= k; j++){
            max = Math.max(max, arr[i - j + 1]);
            if(i - j >= 0)
                dp[i] = Math.max(dp[i], dp[i - j] + max*j);
            else
                dp[i] = Math.max(dp[i], max*j);
        }
    }
    return dp[arr.length - 1];
}
}