// Time Complexity : O(m * k)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

 
public class Problem2 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
    int m = arr.length;
    int dp[] = new int[m];
    dp[0] = arr[0];
    for(int i = 1; i < m; i++){
        int max = arr[i];
        for(int j = 1; j <= k && i - j + 1 >= 0; j++){
            max = Math.max(max, arr[i - j + 1]);
            if(i - j >= 0){
                dp[i] = Math.max(j * max + dp[i - j], dp[i]);
            }
            else {
                dp[i] = Math.max(j * max, dp[i]);
            }
        }
    }
    return dp[m - 1];
}
}
