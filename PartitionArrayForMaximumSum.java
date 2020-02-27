//TC : O(n) where n is lenght of array
//SC : O(n) where n is lenght of array
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        if(A.length == 0 || A == null)
            return 0;
        
        int[] dp = new int[A.length];
        
        for(int i=0;i<A.length;i++){
            int max = 0;
            //Edge case handle
            for(int j=1;j<=K && i-j+1>=0;j++){
                max = Math.max(max,A[i-j+1]);
                if(i-j>=0){
                    //Going j steps back i-j
                    dp[i] = Math.max(dp[i],max*j+dp[i-j]);
                }
                else{
                    dp[i] = Math.max(dp[i],max*j);
                }
            }
        }
        
        
        
        return dp[A.length-1];
    }
}