//Approach: We will be using a DP array to store all the previous max and then use that to calculate further max.

//time complexity O(nK) where n is the size of the array and K is the number of max partitions allowed.

//space complexity O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int[] dp = new int[A.length];
        for(int i = 0; i < dp.length; i++){
            int max = 0;//because everytime i moves, the max value should be reset
            for(int j = 1; i-j+1>=0 && j <= K; j++){//good practice with out of bounds constraints
                max = Math.max(max, A[i-j+1]);
                if(i>=j){
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                } else {
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        return dp[dp.length -1];
    }
}
