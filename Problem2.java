
//Time Complexity: O(n*k)
//Space Complexity: O(n)

//we use dynamic programming to solve this problem as we have repeated subproblems
//we create a 1D dp array to store the maximum sum we can get by partitioning the array
//we iterate through the array and for each element we check the previous k elements and find the
// maximum element among them and calculate the maximum sum we can get by partitioning the array
// we update the dp array with the maximum sum we can get by partitioning the array
//i-j+1 is the starting index of the current partition
//i-j is the ending index of the previous partition
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        dp[0]=arr[0];
        for(int i=0;i<n;i++){
            int currMax=0;
            for(int j=1;j<=k&&i-j+1>=0;j++){
                currMax=Math.max(currMax,arr[i-j+1]);  
                if(i-j>=0)
                    dp[i]=Math.max(dp[i],currMax*j+dp[i-j]);
                else
                    dp[i]=Math.max(dp[i],currMax*j);
            }
        }
        return dp[n-1];
    }
}