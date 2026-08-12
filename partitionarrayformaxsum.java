// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initially had trouble with the base case and the way to calculate the maximum sum for each partition.
// Your code here along with comments explaining your approach : use bottom up dp approach to find the maximum sum for each partition of size k. Keep track of the maximum value in the current partition and update the dp array accordingly.
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
   
    int n = arr.length;
    int [] dp = new int[n];
    dp[0] = arr[0];
    for(int i = 1; i<n; i++){
        int max = 0;
        for(int j = 1; j<= k && i-j+1>=0; j++){
            max = Math.max(max, arr[i-j+1]);
            if(i-j >= 0){
dp[i] = Math.max(dp[i], dp[i-j] + max * j);
            } 
            else{
            dp[i] = Math.max(dp[i], max * j);}
        }
    } return dp[n-1];}
}