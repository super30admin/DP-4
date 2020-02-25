/*
 * Time complexity : O(mn)^2
 * Space complexity : O(1)
 * 
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
        int max = 0;
        int curr = 0;
        int m = matrix.length;
        int n = matrix[0].length; 
        
        boolean flag = true;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(matrix[i][j] == '1'){
                    
                    flag = true;
                    curr = 1;
                    
                    while(i + curr < m  && j + curr < n && flag){
                        for(int k=i+curr; k>=i; k--){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;

                                break;
                            }
                        }

                        for(int k=j+curr; k>=j; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;

                                break;
                            }
                        }

                        if(flag){
                            curr++;
                        }    
                    }
                    
                }
                
                max = Math.max(max, curr);
            }
        }
        
        return max*max;
        
    }
}