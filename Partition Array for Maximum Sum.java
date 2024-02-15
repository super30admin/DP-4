// Time Complexity : O(n * k)
// Space Complexity : O(n)
// Method used : DP

class Solution {

    int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        dp = new int[arr.length];

        return helper(0, arr, k);
    }

    private int helper(int index, int[] arr, int k)
    {
        if(index == arr.length) return 0;

        if(dp[index] != 0) return dp[index];

        // Length is 0 bcoz at each at every index we start from that index and go k time forward
        // So length should be 1 at every index before computation. We made it 1 below.
        int length = 0;

        // max_value will give us maximum value in k partition and maxsum will give me maximum sum over all the partition
        // sums found
        int max_value = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;

        // j starts from index and goes till index + k but some times index + k might cross the array so we should be sure
        // that our j should be in the range of min(n, index + k)
        for(int j = index; j < Math.min(arr.length, index + k); j++)
        {
            // Increment the length as it was 0. But this length keeps on incrementing later till k
            ++length;

            // Keep on calculating the max_value in the partition window
            max_value = Math.max(max_value, arr[j]);

            int sum = length * max_value + helper(j + 1, arr, k);

            maxSum = Math.max(maxSum, sum); 
        }

        return dp[index] = maxSum;
    }
}