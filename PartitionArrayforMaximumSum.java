//Time Complexity: O(kn)
//Space Complexity: O(kn)

/*
 * here we maintain dp array and at each position we calculate maximum
 * of current element and if we make k size partition of the max values.
 * the last value will be the max we can get.
 */


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            int curr = arr[i];
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                curr = Math.max(curr, arr[i-j+1]);
                int newCurr = curr*j;
                if(i - j >= 0){
                    newCurr += dp[i-j]; 
                }
                dp[i] = Math.max(dp[i], newCurr);
            }
        }
        return dp[n-1];
    }
}