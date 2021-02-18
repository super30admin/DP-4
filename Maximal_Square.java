class Maximal_Square {
    
    /*
      Time : O( (M * N) x (M * N)) | for each element diagonal element we are checking row,col is 1
      Space : O(1)
      Leetcode : YES
      Non DP solution
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return -1;
        int n = matrix[0].length;
        int m = matrix.length;
        boolean flag  = false;
        int max = 0;
        
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(matrix[i][j] == '1'){
                    int curr = 1;
                    flag = true;
                    
                    while((i + curr) < m && (j+curr) < n && flag){
                        
                        for(int k = (i+curr); k >= i; k--){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                         for(int k = (j+curr); k >= j; k--){
                                if(matrix[i+curr][k] == '0'){
                                    flag = false;
                                    break;
                                }  
                            }
                        
                        if(flag){
                            curr++;
                        }
                    }
                    
                    max = Math.max(max,curr);
                }
            }
        }
        
        return max*max;
    }
    /*
      Time : O(M * N)
      Space : O(M*N) | dp array space
      Leetcode : YES
      
    */
    //DP Solution
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return -1;
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i-1][j-1] == '1'){
                    // choose best amount three
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max* max;
    }
}
