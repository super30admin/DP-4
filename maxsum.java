//TC: O(n·k) — for each start index i you try up to k partition lengths and do O(1) work.
//SC: O(n) — memo array O(n) plus recursion depth up to O(n) (same order).

//Define dp[i] = max sum achievable from subarray arr[i..].
//For each i, try partition sizes j = 1..k: track maxNum of arr[i..i+j-1], compute maxNum*j + dp[i+j], and take the best.
//Memoize results to avoid recomputation; answer is dp[0] (top-down or bottom-up both work).

class Solution {
    int[] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return helper(arr, 0, k);
    }

    private int helper(int[] arr, int i, int k) {
        if(i >= arr.length) return 0;
        
        if(memo[i] != -1) return memo[i];

        int max = 0;
        int maxNum = 0;

        for(int j = 1; j <= k && i + j <= arr.length; j++) {
            maxNum = Math.max(maxNum, arr[i + j - 1]);
            int currSum = maxNum * j + helper(arr, i + j, k);
            max = Math.max(max, currSum);
        }

        memo[i] = max;
        return max;
    }
}
