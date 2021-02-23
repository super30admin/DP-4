package DP-4;
// Time Complexity : O(n*k) where n is size of the array and k is the size of the partition
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class PartitionArrayForMax {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
         
            int dp[] = new int[arr.length];
            
            for(int i=0;i<arr.length;i++)
            {
                int max = arr[i];
                for(int j=1;j<=k && i-j+1>=0;j++)
                {
                   if(arr[i-j+1]>max) max = arr[i-j+1]; 
                   
                   if(i-j>=0)
                   {
                     dp[i] = Math.max(dp[i], dp[i-j]+max*j);     
                   }else{
                     dp[i] = Math.max(dp[i], max*j);  
                   }
                                  
                }
            }
            
            return dp[arr.length-1];
            
        }
    }
}
