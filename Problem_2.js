// ## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

// Time Complexity : O(nk)
// Space Complexity : O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var maxSumAfterPartitioning = function (arr, k) {

    let n = arr.length;
    let dp = new Array(n);
    dp[0] = arr[0];

    for (let i = 1; i < arr.length; i++) {
        let maxVal = -Infinity;
        let maxSum = -Infinity;
        // Keep a track of the highest number in the k numbers
        for (let j = 1; j <= k; j++) {
            if (i - j + 1 >= 0) {
                maxVal = Math.max(maxVal, arr[i - j + 1]);
            }
            if (i - j >= -1) {
                let prevSum = i - j === -1 ? 0 : dp[i - j];
                // Calculate maximum sum till now and update
                maxSum = Math.max(maxSum, ((maxVal * j) + prevSum));
            }
        }
        dp[i] = maxSum;
    }

    return dp[n - 1];
};