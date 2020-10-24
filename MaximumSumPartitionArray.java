/*
 * #1043. Partition Array for Maximum Sum
 * 
 * Given an integer array arr, you should partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.

 

Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]

Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83

Example 3:

Input: arr = [1], k = 1
Output: 1
 

Constraints:

1. 1 <= arr.length <= 500
2. 0 <= arr[i] <= 109
3. 1 <= k <= arr.length

 */

/*
 * Time Complexity: O (N) To compute max_sum at each point from 0 to arr.length - 1
 * 
 * Space Complexity: O (N) -> Creating a DP array of length same as input array
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP4;

public class MaximumSumPartitionArray {
	public int maxSumAfterPartitioning(int[] arr, int k) {
        
        // #1. Base condition
        if(arr == null || arr.length == 0){
            return 0; // No array, no max sum from contiguous subarrays
        }
        
        /*
        *   Pattern -> Out of multiple possible ways, we have to partition the array into contiguous subarrays optimally to get max sum
        *              Whenever, multiple ways possible and we need to get optimal one and return max or min, these are DP problems
        */
        // #2. Create a DP array of length same as input array length
        int[] dp = new int[arr.length];
        
        // #3. Traverse through DP array and compute max sum at every point
        /*
        *   i -> move forward till the end of DP array
        *   j -> move from 1 to k
        */
        for(int i = 0; i < arr.length; i++){
            // Not initializing "max" as global because at every point -> 'i', we need to reset the max element
            // At every point 'i', we explore the new contiguous subarrays from j = 1 to 3 -> subarray length (exploring elements backwards in DP array)
            int max = Integer.MIN_VALUE; // reset to negative infinity
            
            // Explore the new contiguous subarrays from j = 1 to 3 -> subarray length (exploring elements backwards in DP array)
            // condition -> (i-j+1) is introduced to prevent outOfBounds exception when trying to access a newly added element to a contiguous subarray from input array e.g: when i = 1, j = 3 -> -1 will give error while trying to access from input array
            for(int j = 1; j <= k && (i-j+1) >= 0; j++){
                
                // Whenever a new element is introduced while exploring contiguous subarray at a point, check max(prev max, current element) and update the max accordingly
                max = Math.max(max, arr[i-j+1]); // Above condition is added to prevent error at this line when index is out of bounds in input array
                
                // max at dp[i] -> max(dp[i], previously computed max_sum + max * j);
                // We have max calculated, we have 'j', now need previously computed max_sum
                
                // Check if we have previously computed max_sum in DP array 
                // If we have previous max_sum
                if(i >= j){  
                    // max_sum at dp[i] -> max(dp[i], previously computed max_sum + max * j);
                    /*
                    *   At any point 'i', we compute the max_sum as:
                    *   previously computed max_sum + max_element in contiguous subarray * length of subarray
                    *   (Get prev max_sum by going 'k' steps back from 'i') + ("max" we computed above) * j
                    *   max(dp[i], dp[i-j] + max * j) -> dp[i] = current max_sum at 'i' 
                    */
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                }
                // e.g: [1, 15, 7] -> for this, we do not have previous max_sum, it is 0. i = 2, j = 3 (subarray length)
                /*
                *   previously computed max_sum + max_element in contiguous subarray * length of subarray
                *   0 + ("max" we computed above) * j
                *   max(dp[i], 0 + max * j) -> dp[i] = current max_sum at 'i' 
                *
                */
                else{
                    dp[i] = Math.max(dp[i], 0 + max * j);
                }
              
                
            }
            
        }
        
        // max_sum after partitioning given array into contiguous subarray will be the last element in DP array
        return dp[arr.length - 1];
        
    }

}
