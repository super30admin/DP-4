// Time Complexity : O(n*k)
// Space Complexity : O(n) + O(n) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Using Top Down approach, we will cache the function calls and reuse them.
 * 2. At every index, we will check for 1 to k subarrays and find the max sum as per problem statement.
 * 3. We will return the max sum.
*/

import java.util.Arrays;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return maxSumAfterPartitioning(arr, 0, k, n, memo);
    }

    private int maxSumAfterPartitioning(int[] arr, int index, int k, int n, int[] memo){
        if(index == n)
            return 0;
        
        if(memo[index] != -1)
            return memo[index];

        int maxSum = Integer.MIN_VALUE;
        int max = arr[index];
        int sum = 0;
        for(int i=index; i<index+k && i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            sum = (max) * (i - index + 1);
            maxSum = Math.max(sum + maxSumAfterPartitioning(arr, i+1, k, n, memo), maxSum);
        }

        return memo[index] = maxSum;
    }
}