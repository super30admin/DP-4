/*Algorithm:
    - Traverse through the matrix till we find a 1.
    - Once found we go in the diagnol direction, for each next diagnol element we check if the complete row and column is 1.
    - If the previous step is satisfied we further move down diagnolly.
    
    Time complexity: O(mn * mn)
    Space Complexity: O(1)
    
    Did the code run on leetcode? Yes
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row==0)
            return 0;
        int col = matrix[0].length;
        boolean oneFound = false; //Flag to check if we have 1
        int max= 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]=='1'){
                    oneFound = true;
                    int curr=1;
                    
                    while(i+curr<row && j+curr<col && oneFound){
                        //Check if the whole column is 1 
                        for(int k=i+curr ; k>=i; k--){
                            if(matrix[k][j+curr]=='0'){
                                oneFound=false;
                                break;
                            }
                               
                        }
                         //Check if the whole row is 1 
                        for(int k=j+curr; k>=j; k--){
                            if(matrix[i+curr][k]=='0'){
                               oneFound=false;
                               break; 
                            }
                        }
                        if(oneFound)
                            curr++;
                    }
                    max = Math.max(max,curr);
                }
            }
        }
        
        return max*max;
        
    }
}