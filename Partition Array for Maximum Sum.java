// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //edge 
        if(arr == null || arr.length == 0) return 0;
        //create a dp array
        int [] dp = new int[arr.length];
        //start a for loop to iterate through the array
        for(int i = 0; i < dp.length; i++){
            //set the max 
            int max = arr[i];
            //now do a for loop up to the k(partition) -check bounds
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                //compare the old max with the new incoming element
                max = Math.max(max, arr[i-j+1]);
                //check if the partion is greater than 0
                if(i-j >= 0){
                    //set that dp array index to the calculted max
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                }
                else{
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        //return the last element of the dp array which will be the max
        return dp[arr.length-1];
    }
}