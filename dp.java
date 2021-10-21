public class dp{
     // time complexity : N*K
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/partition-array-for-maximum-sum/
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        int max =0;
        for(int i =1;i<arr.length;i++){
            max = arr[i];
            for(int j =1;j<=k && i-j+1 >=0;j++){
                max = Math.max(max,arr[i-j+1]);
                if(i-j >=0){
                    dp[i]= Math.max(j*max+dp[i-j],dp[i]);
                }else{
                    dp[i]= Math.max(dp[i],j*max);
                }
                
            }
            
        }
        
        return dp[arr.length-1];
        
    }

     // time complexity : M*N
    // space complexity : M*N
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/maximal-square/
    public int maximalSquare(char[][] matrix) {
     
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] nums = new int[rows+1][columns+1];   
        int max = 0;
        for(int i =1;i<nums.length;i++){
            for(int j =1;j<nums[0].length;j++){
                if(matrix[i-1][j-1]== '1'){
                    nums[i][j] = Math.min(nums[i-1][j],Math.min(nums[i-1][j-1],nums[i][j-1]))+1;
                    max = Math.max(nums[i][j],max);
                }
            }
        }
        return max*max;
    }
}