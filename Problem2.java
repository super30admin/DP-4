//Time Complexity : O(k^n) where n is the length of the array and k is the maximum partition size
// Space Complexity : O(n) for the 1D dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
//1. We are using a 1D array to store the maximum sum after partitioning for each index
//2. We iterate through the array and for each element, we consider all possible partitions of size up to k
//3. We update the dp array with the maximum sum found for each partitioning

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //initialize a dp array to store the maximum sum after partitioning
        int [] dp=new int[arr.length];
        //the maximum sum after partitioning for the first element is the element itself
        dp[0]=arr[0];
        //iterate through the array starting from the first element
        for(int i=0;i<arr.length;i++){
            //if the current index is 0, we can only take the first element
            int max=arr[i];
            //iterate through the array from the current index to the next k elements
            //we can take at most k elements in the partition
            for(int j=1;j<=k && i-j+1>=0;j++){
                //update the maximum value in the current partition
                int curr=arr[i-j+1];
                //update the maximum value in the current partition
                //we take the maximum of the current value and the maximum value in the partition
                max=Math.max(max,curr);
                //Check if we can partition the array at the current index
                //If we can partition the array at the current index, we update the dp array with the maximum sum found so far
                if(i-j>=0){
                dp[i]=Math.max(dp[i],max*j+dp[i-j]);
                }
                //If we cannot partition the array at the current index, we update the dp array with the maximum sum found so far
                else{
                    dp[i]=Math.max(dp[i],max*j);
                }
            }
        // If we have reached the end of the array, we return the maximum sum found so far
        }return dp[arr.length-1];
        
    }
}