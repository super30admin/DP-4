  
    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/partition-array-for-maximum-sum/
    Time Complexity for operators : o(n*k) .. n is the length of the string
    Extra Space Complexity for operators : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two for loops and find the minimum window that has string. o(n*2) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) Create dp array of values.
                    B) First for loop will iterate through the array and second will rotate k times to get the vlaues.
                    C) Get the max of the sub array in max field.
                    E) The while iterating thoufh inner array, first we will check if i>=j. This condition needs for first k  elements.
                       As it may go out of the array which does not have value, int that case just get max of (dp[i], max*j)
                    F) Else  get max of (dp[i], dp[i-j] + max * j).
                    G) At the end, return the last element from an array.
    */

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length == 0 || arr == null)
            return 0;
        
        int dp[] = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            
            int max = Integer.MIN_VALUE;
            
            for(int j = 1; j<= k && i-j+1 >=0;j++){
                max = Math.max(max, arr[i-j+1]);
                
                if(i>=j){
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                }else{
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        
        return dp[dp.length-1];
    }
}