import java.util.Arrays;
/**/
public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N=arr.length;
        int[] dp=new int[N];
        Arrays.fill(dp,-1);
        return maxSum(arr,k,dp,0);

    }
    public int maxSum(int[] arr,int k, int[] dp,int start){
        //base
        int N=arr.length;

        if(start>=N) return 0;

        if(dp[start]!= -1){
            return dp[start];
        }

        //logic
        int ans=0;
        int currMax=0;
        int end=Math.min(N,start+k);
        for(int i=start;i<end;i++){
            currMax=Math.max(currMax,arr[i]);
            ans = Math.max(ans, currMax * (i - start + 1) + maxSum(arr, k, dp, i + 1));
        }
        dp[start]=ans;
        return ans;
    }
}
/*
public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maximum = 0;
            int maxSum = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                maximum = Math.max(maximum, arr[i - j]);
                maxSum = Math.max(maxSum, dp[i - j] + maximum * j);
            }
            dp[i] = maxSum;
        }

        return dp[n];
    }
* */