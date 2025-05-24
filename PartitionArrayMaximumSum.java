// Time Complexity : O(n * k) where h = ht of BST
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use dynamic programming to track the maximum sum we can obtain for subarrays ending at each index.
//   - For each index i, try all partition sizes j (1 to k) such that the subarray arr[i-j+1...i] is valid.
//   - Calculate the max in the current partition and add it to the DP value of the previous partition.
//   - Update the dp[i] value with the max of its current value and the current partition sum.

public class PartitionArrayMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];

        for(int i = 0; i < n; i++) {
            int currMax = 0;
            for(int j = 1; j <= k && i-j+1 >= 0; j++) { //2nd condition to make sure we are making correct partition and not going out of bounds
                currMax = Math.max(currMax, arr[i - j + 1]);
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], (currMax * j) + dp[i-j]);    //sum of current partition and previous partiotion of remainig elements
                } else {
                    dp[i] = Math.max(dp[i], (currMax * j));
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        PartitionArrayMaximumSum obj = new PartitionArrayMaximumSum();
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int result = obj.maxSumAfterPartitioning(arr, k);
        System.out.println("Maximum sum after partitioning: " + result); // Expected: 84
    }
}
