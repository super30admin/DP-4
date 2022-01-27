class Solution {
    public int maximalSquare(char[][] matrix) {
        
        // Time Complexity :: O(m*n)- Bruteforce appraoch traversing through diagonals
        // Space Complexity :: O(1)
        
        // rows
        int m = matrix.length;
        
        // columns
        int n = matrix[0].length;
        
        int max = 0;
        
        for (int i =0 ; i< m; i++){
            
            for(int j =0 ; j < n ; j++){
                
                // If 1 , check for the next diagonal element 
                if (matrix[i][j] == '1'){
                    
                    int diagonal = 1;
                    boolean flag = true;
                    
                    // flag will describe the previous square
                    while ( i + diagonal < m && j + diagonal < n && flag == true){
                        
                        // Traverse the newer column
                        for ( int k = i + diagonal ; k >= i; k--){
                            if(matrix[k][j +  diagonal] == '0'){
                                
                                flag = false;
                                break;
                            }
                        }
                        
                         // Traverse the newer row
                        for ( int k = j + diagonal ; k >= j; k--){
                            if(matrix[i +  diagonal][k] == '0'){
                                
                                flag = false;
                                break;
                            }
                        }
                        
                        if (flag == true){
                            diagonal++;
                        }
                        
                      
                    }
                    
                    max = Math.max(max, diagonal);
                    
                }
            }
        }
        
        return max * max;
    }
}