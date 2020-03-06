

//Time Complexity : O(N^2)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : yES
//Any problem you faced while coding this :nO


//Your code here along with comments explaining your approach
/*
we are gonna utilize DP to find max Partition Sum Array
*/

public class MaxPartitionSumArray {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0)
            return 0;
        int dp[] = new int[A.length];
        
        for(int i =0; i < dp.length; i++){
            int max = 0;
            for(int size=1; size <= K && i - size + 1 >= 0; size++){
                max = Math.max(max,A[i - size + 1]);
                if(i - size >= 0){
                    dp[i] = Math.max(dp[i],max * size  + dp[i - j]);
                }
                else {
                    dp[i] = Math.max(dp[i],max * size);
                }
            }
        }
        return dp[A.length - 1];
    }