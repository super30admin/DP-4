//Time complexity - O(n*k)
//Space complexity - O(n)
public class PartitionArrayForMaximumSum {
    static int maxSumAfterPartitioning(int[] arr, int k) {
        int n =  arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 1; j <= k && i-j+1>= 0 ; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        int k = 4;

        System.out.println("The maximum the sum is: "+ maxSumAfterPartitioning(arr, k));
    }
}
