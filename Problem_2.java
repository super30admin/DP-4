
//Time-O(n^2)
//SPace-O(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length; 
        if (n==0) 
            return 0; 
        int[] dp = new int[n+1]; 
        dp[0]=0; 
        
        for (int i=1; i<=n; i++){
            int max = arr[i-1]; 
            for (int j=i; j>i-k && j>0; j--){
                max = Math.max(max, arr[j-1]); 
                dp[i]= Math.max((max*(i-j+1))+dp[j-1], dp[i]); 
            }
        }
        return dp[n]; 
    }
}
