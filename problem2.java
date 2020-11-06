// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, 5ms
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

// Slide a window through the array and calculate the max through max(i-j) and the value at previous dp values

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length; 
        
        if (n==0) return 0; 
        
        int[] dp = new int[n+1]; 
        
        dp[0]=0; 
        
        for (int i=1; i<=n; i++){
            
            int max = arr[i-1]; 
            
            for (int j=i; j>i-k && j>0; j--){
                
                max = Math.max(max, arr[j-1]); 
                
                dp[i]= Math.max((max*(i-j+1))+dp[j-1], dp[i]); 
            }
        }
        
        return dp[n]; 
    }
}