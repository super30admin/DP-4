// Time Complexity : O(n) - iterating through n elements in the array
// Space Complexity : O(n) - dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, handling the index in bounds.


// Your code here along with comments explaining your approach: Dp approach.Approach is to get the maximum sum at each point based on the partition and going back at each step to recheck on choosing the best partition by accessing the values from A and the previously populated dp array values.


class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A==null || A.length==0) return 0;
        int n=A.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            int max=A[i];
            for(int j=1;i-j+1>=0 && j<=K;j++){
                max=Math.max(max,A[i-j+1]);
                if(i>=j){
                    dp[i]=Math.max(dp[i],dp[i-j]+max*j);
                }
                        else{
                            dp[i]=Math.max(dp[i],max*j);
                        }
                
              }
        }
        return dp[dp.length-1];
    }
}