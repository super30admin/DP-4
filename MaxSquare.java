//space: O(mn)
//time: O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans=0;
        int matri[][]= new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
              matri[i][j] =Character.getNumericValue(matrix[i][j]); 
                if(matri[i][j]==1){ans=1;}
                //System.out.print(matri[i][j]+" ");
            }
       // System.out.println();
        }
        
        
        for(int i=1;i<matri.length;i++){
            for(int j=1;j<matri[0].length;j++){
                
        if(matri[i][j]==1 && matri[i-1][j]!=0 && matri[i][j-1]!=0){
                    
matri[i][j]= 1+Math.min(Math.min(matri[i-1][j],matri[i][j-1]),matri[i-1][j-1]);
        ans=Math.max(ans,matri[i][j]);
                }
            }
            
        }
        return ans*ans;
    }
}
