// time complexity: Outer loop iterates over each element in array O(n). Inner loop iterates over at most k elements for each outer iteration  O(k)
// So total time complexity O(n * K)
// space complexity: O(n) due to dp array of size n
public class PartitionArray {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] dp = new int[n];

            // Iterate through the array
            for (int i = 0; i < n; i++) {
                int max = 0;

                // Consider all partition lengths from 1 to k
                for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                    max = Math.max(max, arr[i - j + 1]); // Find max in current partition
                    int currentSum = max * j; // Sum for current partition
                    dp[i] = Math.max(dp[i], (i - j >= 0 ? dp[i - j] : 0) + currentSum);
                }
            }

            return dp[n - 1];
        }

        public static void main(String[] args) {
            PartitionArray solution = new PartitionArray();

            // Example input
            int[] arr = {1, 15, 7, 9, 2, 5, 10};
            int k = 3;

            // Test the function
            int result = solution.maxSumAfterPartitioning(arr, k);
            System.out.println("The largest sum after partitioning is: " + result); // Expected output: 84
        }
    }


