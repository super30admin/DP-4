//TC: O(n*k)
//SC: O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr, k, 0, new Integer[arr.length]);
    }
    
    private int helper(int[] arr, int k, int idx, Integer[] memo) {
        if (idx >= arr.length) 
            return 0;
        
        if (memo[idx] != null) 
            return memo[idx];
        
        int maxSum = 0;
        int maxElement = 0;
        
        for (int i = 1; i <= k && idx + i -1< arr.length; i++) {
            maxElement = Math.max(maxElement, arr[idx + i - 1]);
            maxSum = Math.max(maxSum, maxElement * i + helper(arr, k, idx + i, memo));
        }
        
        memo[idx] = maxSum;
        return maxSum;
    }
}
