//Time = O(nk), n is the length of input array and k is max partition size.
//Space = O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length; // Get length of input array
        int[] dp = new int[n+1]; // Initialize a dp array of length n+1 to store intermediate results

        for (int i = 1; i <= n; i++) {
            int max = arr[i-1]; // Initialize the maximum value seen so far to the current element

            // Loop through previous k elements to check if forming a partition of size k at this position would yield a larger sum than any previous partitions
            for (int j = 1; j <= k && i-j >= 0; j++) {
                max = Math.max(max, arr[i-j]); // Update the maximum value seen so far to be the maximum value of the previous k elements (or all previous elements if there are less than k elements)
                dp[i] = Math.max(dp[i], dp[i-j] + max * j); // Update dp[i] to be the maximum sum possible using the first i elements of the array
            }
        }

        return dp[n]; // Return the maximum sum possible using all n elements of the array
    }
}
