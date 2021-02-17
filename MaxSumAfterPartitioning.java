// Time Complexity : The time complexity is O(nk) where n is the length of the array
// Space Complexity : The space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];

        dp[0] = arr[0];

        for(int i=1;i<arr.length;i++){

            int max = arr[i];

            // Use k previous values to find the optimal partition
            for(int j=1;j<=k && i-j+1 >=0;j++){

                max = Math.max(max,arr[i-j+1]);
                if(i-j >= 0){
                    dp[i] = Math.max(dp[i],max*j+dp[i-j]);
                }
                else{
                    dp[i] = Math.max(dp[i],max*j);
                }

            }
        }

        return dp[arr.length-1];

    }
}