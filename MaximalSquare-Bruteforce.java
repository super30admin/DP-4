//Problem 106: Maximal Square
//TC: O(mn)^2
//SC: O(1)

/*Steps
Bruteforce: For finding the whether it is square or not, just go diagonally. While traversing diagonally, just check all above elements in that column till i are 1 or not and simultaneously check all left elemnts in that row till j are 1 or not. If they are 1 just keep incementing size of square which is curr variable.
Once u got to know that square is not possible, just compare curr with the max and iterate to next element of the matrix.

Finally return the area of square
*/

class Solution106 {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix==null || matrix.length==0) return 0;
        //TC: O(mn)^2 | SC:O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean flag=false;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(matrix[i][j]=='1'){
                    flag = true;
                    int curr = 1;//length of the current square will be 1;
                    
                    //go diagonally
                    while(i+curr<m && j+curr<n && flag){
                        
                        //Now check for the column, whether all elements in that column are '1'
                        //here we have to check k till i, i will be our boundary
                        for(int k=i+curr;k>=i;k--){
                            if(matrix[k][j+curr]!='1'){
                                flag = false;
                                break;
                            }
                        }
                        
                        //Now check for the same row and different columns, whether all elements in that row are '1'
                        //here we have to check k till j, j will be our boundary
                        for(int k=j+curr;k>=j;k--){
                            if(matrix[i+curr][k]!='1'){
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag) curr++;// if flag is true, then only increment the counter
                        
                    }
                    max = Math.max(max,curr);
                }
                
            }
        }
        
        return max*max;
    }
}