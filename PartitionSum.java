/**
 * Time Complexity: O(n * k), where n is the number of elements in the array and k is the maximum partition size.
 * The helper function performs a loop that iterates up to k times for each start index. Since it is called for each index, 
 * the time complexity is O(n * k).

 * Space Complexity: O(n), where n is the number of elements in the array.
 * The space complexity is determined by the DP array of size n, which is used to store the maximum sum for each starting index.
 */


class Solution {
    // Public method to initialize the DP array and start the recursion
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Initialize a DP array where dp[i] will store the maximum sum for subarray starting at index i
        int[] dp = new int[arr.length];
        // Fill DP array with -1 to indicate that no results are computed yet
        Arrays.fill(dp, -1);
        // Call the helper function starting from index 0
        return helper(0, dp, arr, k);
    }

    // Helper function to compute the maximum sum starting from a given index
    private int helper(int start, int[] dp, int[] arr, int k) {
        // Base case: if start index is out of bounds, return 0
        if (start >= arr.length) return 0;
        // If the result for this start index is already computed, return it
        if (dp[start] != -1) return dp[start];

        int maxNum = 0;  // Variable to store the maximum number in the current subarray
        int maxSum = 0;  // Variable to store the maximum sum that can be achieved
        
        // Iterate from the current start index up to k elements or until the end of the array
        for (int i = start; i < start + k && i < arr.length; i++) {
            maxNum = Math.max(arr[i], maxNum);  // Update the maximum number in the current subarray
            // Calculate the sum of the current subarray (maxNum * length) and add the result of the recursive call
            int currentSubarraySum = maxNum * (i - start + 1);
            int nextSum = currentSubarraySum + helper(i + 1, dp, arr, k);
            // Update maxSum with the maximum value between the current maxSum and nextSum
            maxSum = Math.max(maxSum, nextSum);
        }
        
        // Cache the result for the current start index
        dp[start] = maxSum;
        // Return the computed maximum sum for the subarray starting at index start
        return maxSum;
    }
}
