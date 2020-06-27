//Leetcode : 1043. Partition Array for Maximum Sum
//Time compelxity: O(nk), n is the length of the array and k is the size of partition
//Space Complexity: O(n) , size of dp array
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
         if(A==null || A.length==0) return 0;
        int[] dp = new int[A.length];
        for (int i=0; i<A.length ;i++){
            int maxN=Integer.MIN_VALUE;
            for(int j=1; j<=K && i-j+1>=0; j++){
                maxN= Math.max(maxN,A[i-j+1]);
               dp[i] = Math.max(dp[i],(i>=j?dp[i-j]:0)+maxN*(j));
            }
        }
        return dp[A.length-1];
    }
}