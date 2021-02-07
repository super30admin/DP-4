/*
# brute force time - O(k^n) as we are taking k decisions at every step space - O(k^n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or len(arr) == 0:
            return 0
        
        return self.helper(arr, len(arr), k)
    
    def helper(self, arr, index, k):
        if index < 1:
            return 0
        
        max_ele = 0
        max_sum = 0
        for j in range(1, k+1):
            cur_sum = 0
            if index-j >= 0:
                max_ele = max(max_ele, arr[index-j])

                cur_sum = self.helper(arr, index-j, k) + max_ele*j
                
                max_sum = max(max_sum, cur_sum)
        return max_sum


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or len(arr) == 0:
            return 0
        
        dp = [0]*len(arr)
        
        for i in range(len(arr)):
            max_element = float('-inf')
            for j in range(1, k+1):                     // this loop will check what is maximum if new element is kept single and rest answer is added,
                                                        // if new element is merged with previous element and then rest ans is added or if new element is merged with last two elements
                                                        // and then remaining ans is added to it until k elements are merged
                if i-j+1 >= 0:
                    max_element = max(max_element, arr[i-j+1])
                    
                    if i>=j:
                        dp[i]  = max(dp[i], dp[i-j]+max_element*j)
                        
                    else:
                        dp[i] = max(dp[i], max_element*j)
        return dp[len(arr)-1]
*/

// Time - O(kn) where n is array size
// Space - O(n)
// Logic - Maintained a dp which calculated optimum sum upto that index 
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        
        int[] dp = new int[arr.length];
        
        for (int i=0; i<arr.length; i++){
            int max = Integer.MIN_VALUE;
            
            for (int j=1; j<=k; j++){
                if (i-j+1 >= 0){
                    max = Math.max(max, arr[i-j+1]);
                    
                    if (i>=j){
                        dp[i] = Math.max(dp[i], dp[i-j] + max*j);
                    }
                    else{
                        dp[i] = Math.max(dp[i], max*j);
                    }
                }
            }
        }
        return dp[arr.length-1];
    }
}