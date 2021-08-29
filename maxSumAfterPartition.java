//Time complexity: O(NK) //k possibilities for n elements
//Space complexity: O(N) //array for result

class maxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) return 0;
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            int max = arr[i]; //max element
            
            for(int j = 1; j <= k && i - j + 1 >= 0; j++){
                max = Math.max(max, arr[i - j + 1]); //incoming element
                if(i - j >= 0)
                    dp[i] = Math.max(dp[i], dp[i - j] + max * j);
                else
                    dp[i] = Math.max(dp[i], max * j);
                
            }
        }
        return dp[arr.length - 1];
    }
}