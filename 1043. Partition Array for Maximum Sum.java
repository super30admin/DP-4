//time complexity: O(n*k)
//space complexity: O(n)

/*
At each index, we get the max value by comparing elelmt at ith index and elements at previous index upt k steps back.
then we do max * k + previoud calculated sum. 
i.e. dp[i] = max(dp[i], max * j + dp[i-j]);
*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length == 0 || arr == null)return 0;
        
        int[]dp = new int[arr.length];
        
        for(int i = 0; i < dp.length;i++){
            int max = dp[i];
            for(int j = 1; j <= k && (i - j +1)>= 0 ;j++){
                //update the max
                max = Math.max(max, arr[i-j+1]);  //max element in the curr window of j size
                
                if(i - j >= 0){ 
                    dp[i] = Math.max(dp[i], max*j + dp[i-j]); 
                }else{
                    dp[i] = Math.max(dp[i],max*j);
                }
            }
            
            
        }
        
        return dp[arr.length-1];
    }
}