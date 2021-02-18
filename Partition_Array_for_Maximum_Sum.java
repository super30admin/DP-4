 

class Partition_Array_for_Maximum_Sum {
    /*
      Time : O(N * K) | for each element in array we are doing k operations inside arr
      Space : O(N) | extra dp array
      Leetcode : YES
    */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return -1;
        
        int[] dp = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            
            int max = arr[i];
            // i-j+1 is for making sure we are not going out of bounds when i < k (starting 0th index)
            for(int j = 1; j <= k && (i - j + 1) >= 0; j++ ){
                max = Math.max(max, arr[i - j + 1]);
                if(i - j >= 0){
                   dp[i] = Math.max(dp[i], (j * max ) + dp[i-j]);
                }else{
                   dp[i] = Math.max(dp[i], (j * max )); 
                }     
            }
        }
        
        return dp[arr.length - 1];
    }
}
