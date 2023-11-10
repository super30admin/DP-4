// ******************** Another Method: Bottom Up : end-to-start ********************

// Time Complexity:  O(n*k)
// Space Complexity: O(n+k)

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        
        for(int i=arr.length-1; i>=0; i--) {
            int ans = 0, max = 0;
            for(int len=1; len<=k && i+len-1<arr.length; len++) {
                max = Math.max(max, arr[i+len-1]);                             // maintaining max for that window
                ans = Math.max(ans, max*len + dp[i+len]);                      // maintaining dp value sum
            }   
            dp[i] = ans;
        }
     
        return dp[0];
        
    }
}



// // ******************** Another Method: Bottom Up : start-to-end ********************

// // Time Complexity:  O(n*k)
// // Space Complexity: O(n+k)

// class Solution {
//     int k=0;
//     int[] dp;
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         this.k = k;
//         dp = new int[arr.length];
//         Arrays.fill(dp, -1);
//         return partitioning(arr, 0);
//     }
//     private int partitioning(int[] arr, int i) {
        
//         // BASE
//         if(i == arr.length) {
//             return 0;
//         }
        
//         if(dp[i] == -1) {
//             int ans = 0, max = 0;

//             for(int len=1; len<=k && i+len-1<arr.length; len++) {
//                 max = Math.max(max, arr[i+len-1]);                             // maintaining max for that window
//                 ans = Math.max(ans, max*len + partitioning(arr, i+len));       // maintaining dp value sum
//             }   
//             dp[i] = ans;
//         }
     
//         return dp[i];
        
//     }
// }
