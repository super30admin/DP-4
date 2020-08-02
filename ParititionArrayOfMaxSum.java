
//Time Complexity : O(n)
//Space Complexity : O(n)
//Did it run on leetcode : yes

class Solution {
    int max;
    int total;
    public int maxSumAfterPartitioning(int[] A, int K) {
     
      int[] dp = new int[A.length];
      int max = Integer.MIN_VALUE;
      int maxElement = Integer.MIN_VALUE;
      int relation = 0;
       
        for(int i = 0 ; i < A.length; i++){
            max = Integer.MIN_VALUE;
            maxElement = Integer.MIN_VALUE;
            for(int k = 0 ; k < K; k++){
                if(i - k >=0){
                    maxElement = Math.max(A[i-k],maxElement);
                    if(i-k-1 < 0)
                        relation = 0;
                    else
                        relation = dp[i-k-1];
                    max = Math.max(max,(maxElement*(k+1))+relation);    
                }               
            }
            dp[i] = max;   
        }
        return dp[dp.length-1];
    }
    
    
        
        
    
}