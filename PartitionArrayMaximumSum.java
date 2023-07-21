public class PartitionArrayMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = arr[i - 1];
            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PartitionArrayMaximumSum obj = new PartitionArrayMaximumSum();

        int[] arr1 = { 1, 15, 7, 9, 2, 5, 10 };
        int k1 = 3;
        System.out.println("Largest sum for arr1: " + obj.maxSumAfterPartitioning(arr1, k1)); // Output: 84

        int[] arr2 = { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
        int k2 = 4;
        System.out.println("Largest sum for arr2: " + obj.maxSumAfterPartitioning(arr2, k2)); // Output: 83
    }
}
