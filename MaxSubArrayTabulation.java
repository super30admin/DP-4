// Time Complexity : O(N*K) where N is the length of the input array and K is the maximum partition size
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Brute force approach would be to iterate through the array and for each index, we would try to partition the array into all possible sizes from 1 to k and calculate the sum for each partition.
//  We would keep track of the maximum sum found so far and return it at the end. It has repeated sub problems as we are calculating the sum for the same index multiple times, 
// but we are not storing the results of those sub problems, hence it is not a dynamic programming solution.

// Dynamic programming approach would be to use tabulation to store the results of the sub problems.
// We would initialize a dp array of size n + 1 to store the maximum sum for each index. We would iterate through the input array from the end to the beginning and for each index
// we would try to partition the array into all possible sizes from 1 to k and calculate the sum for each partition using the dp array to get the maximum sum for that index.
// We would return the maximum sum for the first index at the end. This approach has a time complexity of O(N*K) and a space complexity of O(N) due to the dp array.
//  However, we can optimize the space complexity to O(1) by using a variable to store


class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int currMax = 0;
            int maxSum = 0;

            for (int j = 1; j <= k && i + j <= n; j++) {

                currMax = Math.max(currMax, arr[i + j - 1]);

                int currSum = currMax * j + dp[i + j];

                maxSum = Math.max(maxSum, currSum);
            }

            dp[i] = maxSum;
        }

        return dp[0];
    }
}