public class PartitionArrayForMaxSum {
  /**
    Time complexity: O(n * k)
    
    Space complexity: O(n)
    */
    public int maxSumAfterPartitioning(int[] arr, int k) {
      int[] dp = new int[arr.length]; // dp array to store sum
      
      for(int i = 0; i < arr.length; i++){
          int tempMax = arr[i];
          for(int j = 0; j < k && i - j >=0; j++) {
              // keep track of the maximum element in the partition
              tempMax = Math.max(tempMax, arr[i - j]);
              
              if(i-j == 0){ // our partition is all the way upto the 0th element.
                  dp[i] = Math.max(dp[i], tempMax * (j+1));
              } else{
                  dp[i] = Math.max(dp[i], dp[i-j-1] + tempMax * (j+1));
              }
          }
      }
      
      return dp[dp.length-1];
  }
}
