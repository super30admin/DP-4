//Brute Force solution
//TC : O(m2n2) m,n are rows and columns
//SC : O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max =0;
        boolean flag = false;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                //Entire action takes place only if the current element is 1
                if(matrix[i][j] == '1'){
                    //Move the pointer diagnally using curr
                     int curr = 1 ;
                    //If (i,j) -> (0,0) ; to move it to (1,1) we do (i+curr,j+curr) when curr=1
                    //If (i,j) -> (0,0) ; curr =2 ; new (i,j) -> (2,2)
                    
                    //While checking all elements horizontally and vertically until (i,j) from the (i+curr,j+curr);
                    //set flag to false , if we encounter a '0'
                    flag = true; 
                    
                    //Moving to the diagnal
                    while(curr+i<m && curr+j < n && flag){
                        
                        //Check all columns
                        for(int k=curr+j;k>=j;k--){
                            if(matrix[curr+i][k] == '0'){
                                flag = false;
                                break;
                            }
                                
                        }
                        
                        
                        //Check all rows
                        for(int k=curr+i;k>=i;k--){
                            if(matrix[k][curr+j] == '0'){
                                flag = false;
                                break;
                            }
                                
                        }
                        

                        //Only if all elements are 1 until then, we increase curr
                        if(flag){ curr++;}
                    }
                     max = Math.max(max,curr); 
                     
                }
                
                    
            }  
           
        }
        
        return max*max;
        
    }
    
}
