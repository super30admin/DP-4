// Time Complexity : O(n*k) 
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach:declare another array dp. Start iterating the array and check for the max 
//in the last k values in the array and update the dp array with the calculated max values.
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length==0)
            return 0;
        int dp[] = new int[arr.length];
        //dp[0]=arr[0];
        for(int i=0;i<arr.length;i++){
            int max=0;
            int sum=0;
            for(int j=1;j<=k && i-j+1>=0;j++){
                max=Math.max(max, arr[i-j+1]);
                sum=Math.max(sum,(i>=j?dp[i-j]:0)+max*j);
            }
            dp[i]=sum;
        }
        return dp[arr.length-1];
    }
}