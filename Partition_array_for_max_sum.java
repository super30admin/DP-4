TC:O(n)
SC:O(n)

Runtime: 5 ms, faster than 60.98% of Java online submissions for Partition Array for Maximum Sum.

Approach: We find the maximum value we can get from taking partition size of 1,2 and 3 of each element before it.We will keep the max value 
for each position in a dp array and for it to be used for the subsequent indexes to find their maximum value that it can get.


class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        
        for(int i=0; i<n ;i++){
            int max = A[i];
            for(int j=1; j<=K && i-j+1 >= 0; j++){
                max =Math.max(max,A[i-j+1]);
                dp[i]= Math.max(max*j+(i>=j?dp[i-j]:0),dp[i]);
            }
        }
        return dp[n-1];
    }
}
