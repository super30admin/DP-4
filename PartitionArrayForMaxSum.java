/* 
Time Complexity: O(n * k)
   - For each index, check up to k previous elements.

Space Complexity: O(n)
   - dp array of size n.

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - Use dynamic programming where dp[i] = max sum achievable for subarray arr[0..i].
// - For each i, try partition sizes j = 1..k (ending at i).
//     * Track currMax = max element in the current partition.
//     * Candidate sum = dp[i-j] + currMax * j.
//     * If i-j < 0, partition covers beginning of array → just currMax * j.
// - Update dp[i] with the best candidate.
// - Answer = dp[n-1].


public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            int currMax = 0;

            for(int j = 1; j <= k && i - j + 1 >= 0; j++){
                currMax = Math.max(currMax, arr[i - j + 1]);

                if(i - j >= 0){
                    dp[i] = Math.max(dp[i], currMax * j + dp[i - j]);
                }else{
                    dp[i] = Math.max(dp[i], currMax * j);
                }
            }
        }
        return dp[n - 1];
    }
}
