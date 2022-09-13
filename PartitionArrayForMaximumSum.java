// Time Complexity : O(n*k) where m = number of elements, k = number of partitions
// Space Complexity : O(n) where n = number of elements
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1043. Partition Array for Maximum Sum (Medium) - https://leetcode.com/problems/partition-array-for-maximum-sum/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
    	// Time Complexity : O(n*k) where m = number of elements, k = number of partitions
    	// Space Complexity : O(n) where n = number of elements
        if (arr == null || arr.length == 0) return 0;
        
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            int max = arr[i];
            
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) { // for each partition
                max = Math.max(max, arr[i-j+1]);
                int currMaxPartition = max * j;
                
                if (i - j >= 0) {
                    currMaxPartition = max * j + dp[i-j];
                }
                
                dp[i] = Math.max(dp[i], currMaxPartition);
            }
        }
        
        return dp[n-1];
    }
}