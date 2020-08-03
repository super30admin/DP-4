class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
       
        int[] dp = new int[A.length];
        //2 pointers one for iterating and one for splitting
        for(int i = 0 ;i < A.length ; i++){
            int max = A[i];
            for(int j = 1; i-j+1 >=0 && j<=K;j++ ){ // j is no of splits starts from 1 and i-j+1>=0
                max = Math.max(max,A[i-j+1]);
                if(i>=j)
                dp[i] = Math.max(dp[i],dp[i-j]+ max*j);
                else
                dp[i] = Math.max(dp[i],max*j);    
            }
        }
        return dp[dp.length-1];
    }
}

/*
Time complexity: n+n+....n --> k times O(nk)
Space complexity: O(n)
*/