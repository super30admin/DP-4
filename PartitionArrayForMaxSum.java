// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
// At every index we try for 1-k partition
// For k element partion, the value of the partition will be max element from [i-k+1 to i] * k
// and the previous subproblem result will be dp[i-k]
// We take the max of all possible partitions at every index and store it in dp array

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i =1;i<n;i++){
            int currentMaxValue = arr[i];
            for(int j=1;j<=k && i-j+1 >=0;j++){
                currentMaxValue = Math.max(currentMaxValue, arr[i-j+1]);
                int currResult = currentMaxValue * j;
                if(i-j>=0)
                    currResult += dp[i-j];

                dp[i]=Math.max(dp[i], currResult);
            }
        }

        return dp[n-1];
    }
}