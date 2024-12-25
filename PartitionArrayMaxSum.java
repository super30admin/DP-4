// Approach : Initial when try to be exhasutive by finding all the partitions and find which partition gives you maximum. Time complexity would be exponential (k^n)
// During that approach you will have repeated subproblem and to solve that using DP.
// Time : O(n*k)
// Space : O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
      int n = arr.length;
      int[] dp = new int[n]; // stores max partition sum
      dp[0]= arr[0];
      for(int i =1;i<n;i++){
        int max = arr[i]; //considering incoming element as the max
        // for each and every element apply the k partitions -> 1<j<=k
        for(int j =1;j<=k && i-j+1 >=0;j++){ // i-j+1 can go negative
            // now new element is coming in with splits. so determine the new max
            max = Math.max(max,arr[i-j+1]);
            if(i-j>=0){ // i-j can go negative
                dp[i] = Math.max(dp[i],max*j+dp[i-j]);
            } else{
                dp[i] = Math.max(dp[i],max*j);
            }
        }

      }
      return dp[n-1];  
    }
}