// TC:O(nm*nm) n - rows, m - colums
// SP: O(1)
// idea : Check right and bottom and diagonal right of each element in the matrix whether it is one or not , if it is not one , 
// then make the flag to false and check the element  . if all three directions are 1, caluculate  length and  store max length;
// repeat the whole process all the element in the matrix.
// LC Run : TLE 

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int rows =  matrix.length;
        if(rows == 0) return 0;
        int cols = matrix[0].length;
        boolean flag = false;
        int maxLen = 0;
        int currLen = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == '1'){
                    currLen = 1;
                    flag = true;
                     System.out.print("\n Checking:["+i+"]"+"["+j+"]");
                    //Check the bottom Right
                    while(i+currLen < rows && j+currLen <cols && flag){
                        
                        // i+currLen  == botto row, j+currLen == next bottcom colum
                        // checking the column next one to i
                        for(int k=i;k<=i+currLen;k++){ 
                        System.out.print("\n Checking:["+k+"]"+"["+j+currLen+"] --> "+ matrix[k][j+currLen]+" \tcurrLen"+currLen );

                            if(matrix[k][j+currLen] == '0'){
                                
                                flag = false;
                                break;
                            }
                        }
                        // checking the row below  one to i
                        for(int k=j;k<=j+currLen;k++){
                        System.out.print("\n Checking:["+i+currLen+"]"+"["+k+"] --> "+ matrix[i+currLen][k]+" \tcurrLen"+currLen );
                           if(matrix[i+currLen][k] == '0'){
                               
                                flag = false;
                                break;
                            } 
                        }
                        
                        if(flag){
                            currLen++;
                          System.out.print("\n For:["+i+"]"+"["+j+"] -->currLen"+currLen );

                        }
                    }
                    
                    // compare the ares
                    maxLen  = Math.max(maxLen,currLen);
                }
            }
        }
        return maxLen*maxLen;
    }
}
