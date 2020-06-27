


//Leetcode : 221. Maximal Square
Approach1: Without extra space
Time complexity: O(n^2) where n is the number of elements in the matrix
Space Complexity: O(1), No extra space has been used

class Solution {  
    public int maximalSquare(char[][] matrix) {
        int max=0;
        boolean flag=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0 ; j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    int c=1;
                    flag= true;
                    max= Math.max(max,c);
                    while(flag && i+c<matrix.length && j+c<matrix[0].length ){
                        if(matrix[i+c][j+c]!='1'){
                            flag= false;
                            break;
                        }
                        //col
                        for(int k=i+c;k>=i;k--){
                            if(matrix[k][j+c]!='1'){
                                flag= false;
                                 break;
                            }
                        }
                        //row
                        for(int k=j+c;k>=j;k--){
                            if(matrix[i+c][k]!='1'){
                                flag= false;
                                 break;
                            }
                        }
                        c++;
                        if(flag) max= Math.max(max,c);
                        
                        
                    }
                    
                    
                }
            }
        }
        return max*max;
    }
}=======================================================
Approach2: Using DP with better Time complexity
//Time Complexity: O(n) ,where n is the number of elements in matrix
//Space Complexity: O(n), extra space used for DP matrix
class Solution {    
    public int maximalSquare(char[][] matrix) {
        int max=0;
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];    
        for(int i=0;i<matrix.length;i++){       
            for(int j=0 ; j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                        if(i==0 || j==0){
                            dp[i][j]= matrix[i][j]-'0';
                        }
                        else{
                           
                            dp[i][j]= Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]), dp[i-1][j] )+1 ;
                        }
                    max= Math.max(max,dp[i][j]);
                    
                    }              
            }
          //  System.out.println(Arrays.toString(dp[i]));
        }
        return max*max;
    }
}


====================================

