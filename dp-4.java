class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int columns = matrix[0].length;
        boolean flag = false;
        int cur = 0;
        int max = 0;
        for(int i= 0;i<rows;i++){
            for(int j= 0;j<columns;j++){
                if(matrix[i][j]=='1'){
                    cur = 1;
                    flag = true;
                    while(i+cur <rows && j+cur<columns && flag){
                        for(int k = i;k<=i+cur;k++){
                            if(matrix[k][j+cur] == '0'){
                              flag = false ;
                                break;  
                            }
                        }
                        for(int k = j;k<=j+cur;k++){
                            if(matrix[i+cur][k] == '0'){
                                flag = false; 
                                break;  
                            } 
                        }
                        if(flag) cur++;
                    }
                   max = Math.max(max,cur); 
                }
            }
        }
        return max*max;
    }
}