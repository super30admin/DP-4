//Time Complexity : O(nk)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr==null||arr.length==0){
            return 0;
        }
        int n = arr.length;
        //use a dp array to store the maximum sum for every subarray
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            //let the ith element be max initially
            int max = arr[i];
            //look for max in subarry of length atmost k
            for(int j=1;j<=k && i-j+1>=0;j++)//i-j+1 checks for out of bounds when trying to go back and get the max value
            {
                //get the max value starting from jth index
                max = Math.max(max,arr[i-j+1]);
                //if there are prev items that can be checked for max
                if(i-j>=0){
                    //max of current element or prev element + max * length of subarray
                    dp[i] = Math.max(dp[i],dp[i-j] + max*j);//at this point, the max is added with the previous max considering this as the final result so far
                }
                else{
                    //otherwise, find the max between the current element and previous max
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[n-1];
    }
}