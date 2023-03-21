/*
Partition Array For Maximum Sum
approach: at each element we have to check length of partition that will give us maximum sum
time: dp: O(n) exhaustive: 3^k
space: O(n)
 */
public class Problem2 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i=1;i<n;i++) {
            int max = arr[i];
            for(int j = 1;j<=k && i-j+1>=0;j++) {
                max = Math.max(max, arr[i-j+1]);
                int part  = max*j;
                if(i-j>=0) part+=dp[i-j];
                dp[i] = Math.max(part, dp[i]);
            }
        }

        return dp[n-1];
    }
}
