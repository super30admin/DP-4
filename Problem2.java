public class Problem2 {
    // DP solution
    // TC : O(n)
    // SC : O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;

        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[n - 1];
    }

    public int maxSumAfterPartitioning1(int[] arr, int k) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = arr[i - 1];
            for (int j = i; j > i - k && j > 0; j--) {
                max = Math.max(max, arr[j - 1]);
                dp[i] = Math.max((max * (i - j + 1)) + dp[j - 1], dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        System.out.println("Final value " + problem2.maxSumAfterPartitioning1(arr, 3));
    }
}
