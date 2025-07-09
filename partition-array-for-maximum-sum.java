//First solution comes in mind is Greedy. Find max and make a partition, find next max and make another partition.
//But Greedy can fail at some partitions

// //Brute Force: recursive with partition. Gives time exceed error hence added memoization
// //signle partition, double partition, tripple partition...upto k partition
// //Time = O(k^n) , exponentinal. At each level, we have k paritions
// class Solution {
//     int [] memo;
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         this.memo = new int[arr.length];
//         Arrays.fill(memo,-1);
//         return helper(arr,k,0);
//     }
//     private int helper(int[] arr, int k, int idx){
//         //base
//         if(idx >= arr.length) return 0;
//         if(memo[idx]!=-1) return memo[idx];
//         //logic
//         int max = 0;
//         int maxPartition = arr[idx];
//         for(int j=1; j<=k && idx+j-1<arr.length; j++){
//             maxPartition = Math.max(maxPartition, arr[idx+j-1]);
//             int curr = maxPartition * j + helper(arr,k,idx+j);
//             max = Math.max(max,curr);
//         }
//         memo[idx]=max;
//         return max;
//     }
// }

//Repeated subproblems, hence DP
//Time = O(n*k)
//Space = O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i=1; i<arr.length; i++){
            int max = arr[i];
            for (int j=1; j<=k && i-j+1 >= 0; j++){
                //in
                int curr = arr[i-j+1];
                max = Math.max(max,curr);
                if(i-j >= 0){
                    dp[i] = Math.max(dp[i], max*j + dp[i-j]);
                } else {
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[arr.length-1];
    }
}