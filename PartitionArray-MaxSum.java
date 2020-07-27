/**
 * Brute Force: Partition and get all possible solutions and then get the max sum amongst them.
 * Time: O(k^n) k-gvn k and n - A.length
 * Space: O(n) recursive stack space
 */
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        return helper(A,0,K);

    }
    private int helper(int[]A, int idx, int K){
        // base
        if(idx >= A.length) return 0;

        //logic
        int max = 0;

        int local = 0,maxele = 0;
        for(int j = 0; idx+j < A.length && j<K;j++){
            local = 0;
            maxele = Math.max(maxele, A[j+idx]);
            local = (helper(A,idx+j+1,K) + (maxele*(j+1)));
            max  = Math.max(max,local);
        }

        return max;
    }
}

/**
 * Time: O(n*k) n- length of A and k-given value k
 * Space: O(n)
 */
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        int[] dp = new int[A.length+1];
        dp[0] = 0;

        for(int i=0;i<A.length;i++){
            int local = 0;
            int maxele = 0;
            for(int j=1;i-j+1 >= 0 && j<=K;j++){
                maxele = Math.max(maxele,A[i-j+1]);
                local = Math.max(local,dp[i-j+1]+maxele*j);
            }
            dp[i+1] = local;
        }
        return dp[dp.length-1];
    }
}