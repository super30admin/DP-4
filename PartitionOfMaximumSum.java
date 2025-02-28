// TC: O(nk) as all the elements in the input array is traversed and k times for checking the max
// SC: O(n) which is dp array.

public class PartitionOfMaximumSum {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[] { 1, 15, 7, 9, 2, 5, 10 }, 3)); // 84
        System.out.println(maxSumAfterPartitioning(new int[] { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 }, 4)); // 83
        System.out.println(maxSumAfterPartitioning(new int[] { 1 }, 1)); // 1
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0)
            return 0;
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + j * max);
                } else {
                    dp[i] = Math.max(dp[i], j * max);
                }
            }
        }
        return dp[n - 1];
    }
}
