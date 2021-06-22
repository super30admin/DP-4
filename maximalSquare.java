//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix.length == 0){
            
            return -1;
        }
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        boolean flag = true;
        //boolean hitting = false;
        int max = 0;
      //  int count = 0;
        for(int i = 0; i < r; i ++){
            
            for(int j = 0; j < c; j ++){
                
                if(matrix[i][j] == '1'){
                    
                    int curr = 1;
                    int count = 1;
                    while(curr + i < r && curr + j < c && flag){
                        
                        for(int k = curr + i ; k >= i ; k -- ){
                            
                            if(matrix[k][curr+j] != '1'){
                                
                                flag = false;
                            }
                        }
                         for(int k = curr + j ; k >= j ; k-- ){
                            
                            if(matrix[curr+i][k] != '1'){
                                
                                flag = false;
                            }
                        }
                        
                        if(flag){
                            
                            count ++;
                            curr = curr + 1;
                        }
                    }
                
                    max = Math.max(max, count );   
                }
                flag = true;
               // count = 0;
            }
        }
        return max* max;
    }
}