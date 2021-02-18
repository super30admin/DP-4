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
}
