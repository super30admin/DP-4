// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Approach: Find currMax from present k elements
// Get the best(max) by adding prev best assigned to dp[i-j] and currMax by k times effectively
 //TC: O(n*k)
//SC: O(len+1)= O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int K) {
        int len = arr.length;
        int dp[] = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int currMax = 0, best = 0;
            for (int j = 1; j <= K && i - j >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j]);
                best = Math.max(best, dp[i - j] + currMax * j);}
            dp[i] = best;
        }
        return dp[len];
    }
}