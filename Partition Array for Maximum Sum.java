//TC = O(n*k)
//SC = O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++)
        {
            int maxOfWindow = arr[i];
            for(int j = 1; j<=k && (i-j+1>=0); j++)
            {
                maxOfWindow = Math.max(maxOfWindow, arr[i-j+1]);
                int curValue =  maxOfWindow*j;
                if(i-j>=0)
                {
                    curValue = dp[i-j] + curValue;
                }
                dp[i] = Math.max(dp[i], curValue);
            }
        }
        return dp[n-1];
    }
}
