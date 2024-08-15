// TC:O(nk)
public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        // Initialize the first element in dp
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int currPart = 0;
            int maxSum = 0;

            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                currPart = Math.max(currPart, arr[i - j + 1]);
                int currSum = currPart * j;
                if (i - j >= 0) {
                    currSum += dp[i - j];
                }
                maxSum = Math.max(maxSum, currSum);
            }
            
            dp[i] = maxSum;
        }

        return dp[n - 1];
    }
}
 
