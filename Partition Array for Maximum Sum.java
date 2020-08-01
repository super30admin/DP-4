// Time Complexity : O(kn), K : max partition size, n is input length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//TC : Kn (partition size * input array length)
//SC : n
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        //if empty input, return 0
        if(A == null || A.length == 0) return 0; 
        int n = A.length;
        //create dp array to calc max sum upto index position
        int[] dp = new int[n];
        //for each index
        for(int i = 0; i < n; i++) {
            //initial max is val at index i
            int max = A[i];
            //check partition of size 1-k, 
            //ifi-j+1 < 0 then partition of j val cannot be formed (index will be less than 0)
            for(int j = 1; j <= K && i-j+1 >= 0; j++) {
                //find new max (max in the partition) (find max : new added index's val to partition) 
                max = Math.max(max , A[i-j+1]);
                //if i < j, then no dp[i-j] index exists, 
                //so max dp[i] can be between dp[i] and max*j (max * partition size)
                if(i < j) {
                    dp[i] = Math.max(dp[i], max*j);
                }
                //if i >= j
                //max dp[i] can be between dp[i] and val before partition (dp[i-j]) + max*j
                else {
                    dp[i] = Math.max(dp[i], dp[i-j] + max*j);
                }         
            }
        }
        //max partition sum will be at last index
        //return dp[n-1]
        return dp[n-1];
    }
}

