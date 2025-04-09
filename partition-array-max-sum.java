// TC: O(n^2)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSumAfterPartitioning(arr, 0, k);
    }
    
    private int maxSumAfterPartitioning(int[] arr, int index, int k) {
        if (index == arr.length) {
            return 0;
        }
        
        int ans = 0;
        int maxInPart = 0;
        
        for (int part = 1; part <= k; ++part) {
            int end = index + part - 1;
            if (end == arr.length) break;
            maxInPart = Math.max(maxInPart, arr[end]);
            ans = Math.max(ans, maxInPart * part + maxSumAfterPartitioning(arr, end + 1, k));
        }
        
        return ans;
    }
}
