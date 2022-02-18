// Time Complexity :O(mn)^2
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        boolean flag = false;
        int max =0;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    flag = true;
                    int curr = 1;
                    while(i + curr < m && j+curr < n && flag){
                        //column check
                        for(int k =i;k<=i+curr;k++){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //row check
                        for(int k =j;k<=j+curr;k++){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                         if(flag) curr++;   
                    }
                     max = Math.max(max,curr);
                }
                
            }
        }
        return max * max;
    }
}
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int maximalSquare(char[][] matrix) {
       if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int [][] dp = new int[m+1][n+1];//we need to have one extar row when we are doing bottom up dp
        int max = 0;
        for(int i = 1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],(Math.min(dp[i][j-1],dp[i-1][j])))+1;
                    max = Math.max(max,dp[i][j]);
                    }
                
            }
        }
        return max * max;
    }
}
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr ==null || arr.length == 0) return 0;
        int m = arr.length;
        int [] dp = new int[m];
        dp[0] = arr[0];
        for(int i = 1;i<m;i++){
            int max = dp[i];
            for(int j = 1;j <= k && i-j+1 >= 0;j++){
                 max = Math.max(max,arr[i-j+1]);
                if(i-j >=0){
                     dp[i] = Math.max(dp[i],dp[i-j]+ max * j);
                }else
                    dp[i] = Math.max(dp[i], max * j);
            }
        }
        return dp[dp.length-1];
    }
}

