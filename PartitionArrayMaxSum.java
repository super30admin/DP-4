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
        int max = arr[i]; //considering incoming element as the max element
        // for each and every element apply the k partitions
        for(int j =1;j<=k && i-j+1 >=0;j++){ // j- no of elements for each partition
            max = Math.max(max,arr[i-j+1]);
            if(i-j>=0){
                dp[i] = Math.max(dp[i],max*j+dp[i-j]);
            } else{
                // if i-j+1 < 0 then no element to compare with
                dp[i] = Math.max(dp[i],max*j);
            }
        }

      }
      return dp[n-1];  
    }
}