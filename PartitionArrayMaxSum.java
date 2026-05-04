// // Recursive TLE O(k^n) time, O(n) space 
// class Solution {
//     int maxSum = 0;

//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         helper(0, k, arr, 0);
//         return maxSum;
//     }

//     private void helper(int i, int k, int[] arr, int sum) {

//         if (i == arr.length) {
//             maxSum = Math.max(maxSum, sum);
//             return;
//         }

//         int maxNum = 0;

//         for (int j = 1; j <= k && i+j <= arr.length; j++) {

//             maxNum = Math.max(maxNum, arr[i + j - 1]); // arr[i + j - 1] is incoming elem
            
//             helper(i + j, k, arr, sum + maxNum * j); // j represents how many nums in that partition
//         }
//     }
// }

// Bottom up O(n * k) time, O(n) space 
class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 0; i < n; i++) {
            int maxNum = 0;

            for (int j = 1; j <= k && i-j+1 >= 0; j++) {
                maxNum = Math.max(maxNum, arr[i - j + 1]); // arr[i - j + 1] is incoming elem

                if (i-j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i-j] + maxNum * j);
                }
                else {
                    dp[i] = Math.max(dp[i], maxNum * j);
                }
            }
        }
        return dp[n-1];
    }
}