// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: Tabulation DP
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]= new int[arr.length];
        int n= arr.length;
         for(int idx=n-1; idx>=0;idx--){
            int max=Integer.MIN_VALUE;
            int ans=0;
            int length=0;
            int sum=0;
            for(int i=idx; i<k+idx && i<n; i++){
                length++;
                max=Math.max(max, arr[i]);
                sum= length*max+(i+1<n ?dp[i+1]:0);
                ans=Math.max(ans, sum);
            }
            dp[idx]=ans;
            
         }
         return dp[0];
    }
    }

   