// Time Complexity : O(N+k) - N is the length of the arr.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MaximalSquare {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        // base case
        if(arr.length == 1) return arr[0];
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        
        for(int i = 1; i < dp.length; i++){
            // Selecting the current index as max value.
            int max = arr[i];
            
            // choosing a window size of 1 to k.
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                // Compute the new max using the incoming element.
                max = Math.max(max, arr[i-j+1]);

                // After calculating the new max, compute the previous sum.
                // If the window ends at start of the array then prev sum is 0.
                // If not fetch the previous sum using from the dp matrix.
                int prevSum = (i-j >= 0) ? dp[i-j] : 0;

                // compute the new product sum and assign the max value to the current dp array.
                dp[i] = Math.max(dp[i], max*j+prevSum);
            }
        }

        // In the end, the value at the last index consists of the max product sum that can be obtained using k partitions.
        return dp[arr.length-1];
    }
}
