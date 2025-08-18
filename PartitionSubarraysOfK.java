// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : At each idx, check if k possible arrays ending at k, get the max and it to the subproblem of 0->i-k
class Solution {
    int dp[] ;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, 0, k);
    }
    public int helper(int arr[], int i, int k){
        if(i>=arr.length){
            return 0;
        }
        int sum = arr[i];
        int max = arr[i];
        int res = sum;
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int j=i;j<i+k && j<arr.length;j++){
            
            max = Math.max(arr[j], max);
            sum = Math.max(sum,max * (j-i+1));
            res = Math.max(res, sum + helper(arr, j+1 ,k));
        }
        return dp[i] = res;
    }
}