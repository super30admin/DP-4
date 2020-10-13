//TC: O(n*k) for every n element we iterate k times
//SC: O(n)
public class PArtitionArrayforMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return 0;
        int[] dp = new int[arr.length];
        
        for (int i = 0; i < dp.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= k && i-j+1 >= 0; j++) {
                max = Math.max(arr[i-j+1], max);
                if(i>=j){
                    dp[i] = Math.max(dp[i], dp[i-j]+max*j);
                }
                else{
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[dp.length-1];
    }
}