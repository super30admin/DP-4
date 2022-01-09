// 1043 Partition array for max sum
// # Time O(n * k)
//  Space O(n)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        
        
        for(int i = 1; i < dp.length; i++){
            
            int max = arr[i];
            
            for(int partition = 1; partition <= k; partition++){
                
                if(i - partition < 0)
                {
                    dp[i] = Math.max(dp[i], partition * max);
                        
                    break;
                }
                dp[i] = Math.max(dp[i], dp[i - partition] + partition * max);
                max = Math.max(max, arr[i - partition]);
            }
        }
        
        return dp[dp.length - 1];
    }
}