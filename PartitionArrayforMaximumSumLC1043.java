class Solution {
    
       //DP Approach 4,  Bottom Up Approach, Optimized bottom up approach, because we need k element to check for current max, so we dont need to store n element into dp array, Also, we are making k size dp array and we maintaining the dp array via circular array concept
    
    //Time Complexity: O(n*k), time needed to fill each dp state is O(k) and we have n such dp state, so total O(n*k)
    //Space Complexity : O(k), k for dp array
    
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int[] dp = new int[k];
        
        for(int i = arr.length-1; i>=0; i--){
            
            int max = 0;
            int ans =0;
            for(int len = 1; len<=k && i+len-1<arr.length; len++){
                
                max = Math.max(max, arr[i+len-1]);
                ans = Math.max(ans, max*len + dp[(i+len)%k]);
                
            }
            dp[i%k] = ans;
            //System.out.println(Arrays.toString(dp));
            
        }
        return dp[0];
        
    }
    
    
    
      // DP Approach 3, Bottom Up Approach 1, here I have implemented the bottom up approach starting from end of the array, but we can implement the bottom up approach starting from the start of the array
    
    //Time Complexity: O(n*k), time needed to fill each dp state is O(k) and we have n such dp state, so total O(n*k)
    //Space Complexity : O(n), n for dp array
    
//     
//     public int maxSumAfterPartitioning(int[] arr, int k) {
        
//         int[] dp = new int[arr.length + 1];
        
//         for(int i = arr.length-1; i>=0; i--){
            
//             int max = 0;
//             int ans =0;
//             for(int len = 1; len<=k && i+len-1<arr.length; len++){
                
//                 max = Math.max(max, arr[i+len-1]);
//                 ans = Math.max(ans, max*len + dp[i+len]);
                
//             }
//             dp[i] = ans;
            
//         }
//         return dp[0];
        
//     }

    
    
    
    
    
    
    
    
    
    
    //DP Approach 1, Bottom-up Approach
    
    //Time Complexity: O(n*k), time needed to fill each dp state is O(k) and we have n such dp state, so total O(n*k)
    //Space Complexity : O(n), n for dp array
    
//     public int maxSumAfterPartitioning(int[] arr, int k) {
     
//         int n = arr.length;
//         int[] dp = new int[n];
        
//         dp[0] = arr[0];
        
//         for(int i=1; i<n ; i++){
            
//             int max = arr[i];
            
//             for(int j = 1; j<=k && i-j+1 >=0; j++){
                
//                 max = Math.max(max, arr[i-j + 1]);
//                 int curr = 0;
                
//                 if(i-j >=0){
//                     curr = max*j + dp[i-j];
//                 }
//                 else{
//                     curr = max*j;
//                 }
//                 dp[i] = Math.max(dp[i], curr);   
//             }
//         }
//         return dp[n-1];
//     }
    
    
    
    
    
    // DP Approach 1, Top-Down (memoization) approach
    //Time Complexity: O(n*k), time needed to fill each dp state is O(k) and we have n such dp state, so total O(n*k)
    //Space Complexity : O(n + k), n for dp array and k for recursive stack
    
//     int[] dp;
//     public int maxSumAfterPartitioning(int[] arr, int k) {
        
//         dp = new int[arr.length];
//         Arrays.fill(dp, -1);
//         return maxSumAfterPartitioning(arr, 0, k);
        
//     }
    
//     private int maxSumAfterPartitioning(int[] arr, int index, int k){
        
//         //base
//         if(index == arr.length){
//             return 0;
//         }
        
//         if(dp[index] == -1){
        
//             int ans =0;
//             int max = 0;
//             for(int len = 1; len<=k && index+len-1<arr.length; len++){

//                 max = Math.max(max, arr[index + len - 1]);
//                 int ans2 = max * len + maxSumAfterPartitioning(arr, index + len, k);
//                 ans = Math.max(ans, ans2);

//             }
//             dp[index] = ans;
            
//         }
//         return dp[index];
        
//     }
    
    
    
    
    
    
//     //Time Complexity: O(2^n)
//     //Space Complexity : O(n), gives time limit error, recursive approach 2
//      public int maxSumAfterPartitioning(int[] arr, int k) {
        
//         return maxSumAfterPartitioning(arr, 0, k);
        
//     }
    
//     private int maxSumAfterPartitioning(int[] arr, int index, int k){
        
//         //base
//         if(index == arr.length){
//             return 0;
//         }
        
//         int ans =0;
//         int max = 0;
//         for(int len = 1; len<=k && index+len-1<arr.length; len++){
            
//             max = Math.max(max, arr[index + len - 1]);
//             int ans2 = max * len + maxSumAfterPartitioning(arr, index + len, k);
//             ans = Math.max(ans, ans2);
            
//         }
//         return ans;
        
//     }
    
    
    
    
    
    
    
    
    //Time Complexity: O(2^n)
    //Space Complexity : O(n), gives time limit error, recursive approach 1
//     public int maxSumAfterPartitioning(int[] arr, int k) {
        
//         return maxSumAfterPartitioning(arr, 0, 0, 0, k);
        
//     }
    
//     private int maxSumAfterPartitioning(int[] arr, int index, int max, int length, int k){
        
//         //Base
//         if(index == arr.length){
//             return max*length;
//         }
        
//         //Partition
//         int ans = max*length + maxSumAfterPartitioning(arr, index+1, arr[index], 1, k);
        
//         //Not Partition
//         if(length < k){
//             int ans2 = maxSumAfterPartitioning(arr, index + 1, Math.max(arr[index], max), length+1, k);
//             ans = Math.max(ans, ans2);
            
//         }
//         return ans;
        
//     }
}
