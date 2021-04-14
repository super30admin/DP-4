// Time Complexity : O(n*k) where n - array length, k - maximum length of partition array
// Space Complexity : O(n) where n - dp array length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length == 0|| arr == null) return 0;
        int n = arr.length;
        int[] dp = new int[n];
        
        for(int i=0;i<arr.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<=k && i-j+1>=0;j++){
                max = Math.max(max, arr[i-j+1]);
                if(i >= j)
                    dp[i] = Math.max(dp[i],max*j+dp[i-j]);
                else
                    dp[i]= Math.max(dp[i],max*j);
            }
        }
        return dp[n-1];
    }
}
